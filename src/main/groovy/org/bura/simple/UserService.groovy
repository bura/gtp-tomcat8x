package org.bura.simple

class UserService {
    private final Map<Long, User> users

    UserService() {
        users = new HashMap()
        users[1L] = new User(id: 1L, name: 'Andrey Bloschetsov', gender: 1, email: 'bloschetsov@gmail.com', location: 'Moscow, Russia')
        users[2L] = new User(id: 2L, name: 'Mary Taylor', gender: 2, email: 'mary.taylor@mail.com', location: 'Denver, Colorado')
        users[3L] = new User(id: 3L, name: 'Thomas Davis', gender: 1, email: 'thomas.davis@mail.com', location: 'Mountain View, California')
        users[4L] = new User(id: 4L, name: 'Jack Brown', gender: 1, email: 'jack.brown@mail.com', location: 'London, UK')
        users[5L] = new User(id: 5L, name: 'Manavta Sharma', gender: 2, email: 'manavta.sharma@mail.com', location: 'New Delhi, India')
    }

    List<User> getAll() {
        new ArrayList(users.values())
    }

    User get(long id) {
        users[id]
    }
}
