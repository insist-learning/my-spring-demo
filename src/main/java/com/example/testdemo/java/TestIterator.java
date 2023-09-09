package com.example.testdemo.java;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestIterator {
    record User(String name,Boolean flag){}


    static class UserData implements Iterable<User>{
        private List<User> userList;

        public void setUserList(List<User> userList) {
            this.userList = userList;
        }

        public List<User> getUserList() {
            return userList;
        }

        @Override
        public Iterator<User> iterator() {
            return new Iterator<User>() {
                private Iterator<User> iterator = getUserList().iterator();
                private User next = null;

                @Override
                public boolean hasNext() {
                    return fetchNext()!=null;
                }

                @Override
                public User next() {
                    User user = fetchNext();
                    this.next = null;
                    return user;
                }

                private User fetchNext() {
                    if (this.next != null) {
                        return next;
                    }
                    if (iterator.hasNext()) {
                        User next1 = iterator.next();
                        if (!next1.flag) {
                            return fetchNext();
                        }
                        this.next = next1;
                        return this.next;
                    };
                    return null;
                }

            };
        }
    }


    public static void main(String[] args) {
        UserData userData = new UserData(){
            {
                setUserList(new ArrayList<>(){
                    {
                        add(new User("user1",true));
                        add(new User("user2",false));
                    }
                });
            }
        };
        for (User userDatum : userData) {
            System.out.println(userDatum.name);

        }

    }
}
