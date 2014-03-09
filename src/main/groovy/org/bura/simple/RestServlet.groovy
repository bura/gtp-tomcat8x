package org.bura.simple
import javax.servlet.ServletConfig
import javax.servlet.ServletException
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(value = RestServlet.API_FILTER, loadOnStartup = 1)
class RestServlet extends HttpServlet {
    public static final String API_FILTER = '/api/*'
    public static final String USERS_PATH = '/users'
    public static final String USER_PATH = '/user/'
    
    private static final String INVALID_ID = 'error.invalidUserId'
    private static final String NOT_FOUND = 'error.notFound'
    private static final String INTERNAL_ERROR = 'error.internal'

    private RestController controller
    private Properties props

    @Override
    void init() throws ServletException {
        controller = new RestController(new UserService())
        props = new Properties()
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader()
        props.load(classLoader.getResourceAsStream('application.properties'))
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String body
            if (req.pathInfo == USERS_PATH) {
                body = controller.users()
            } else if (req.pathInfo.startsWith(USER_PATH)) {
                String strId = req.pathInfo.substring(USER_PATH.length())
                long id
                try {
                    id = Long.parseLong(strId)
                } catch (NumberFormatException nfe) {
                    writeResult(resp, HttpServletResponse.SC_FORBIDDEN, controller.error(props.getProperty(INVALID_ID)))
                    return
                }
                body = controller.user(id)
            }

            if (body) {
                writeResult(resp, HttpServletResponse.SC_OK, body)
            } else {
                writeResult(resp, HttpServletResponse.SC_NOT_FOUND, controller.error(props.getProperty(NOT_FOUND)))
            }
        } catch (any) {
            writeResult(resp, HttpServletResponse.SC_INTERNAL_SERVER_ERROR, controller.error(props.getProperty(INTERNAL_ERROR)))
        }
    }

    private void writeResult(HttpServletResponse resp, int status, String body) {
        resp.with {
            status = status
            characterEncoding = 'UTF-8'
            setHeader('Content-Type', 'application/json')
            writer << body
            writer.flush()
            writer.close()
        }
    }
}
