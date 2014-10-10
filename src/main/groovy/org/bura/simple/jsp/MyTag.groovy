package org.bura.simple.jsp

import javax.servlet.jsp.JspException
import javax.servlet.jsp.tagext.SimpleTagSupport

class MyTag extends SimpleTagSupport {

    @Override
    void doTag() throws JspException, IOException {
        jspContext.out.println('This is my Tag!')
    }
}