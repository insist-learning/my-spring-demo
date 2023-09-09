package com.example.testdemo.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class TestCustomIterator {
    record User(String name) { }

    static class UserData implements Iterable<UserData>{
        UserData(User user) {
            this.currentUser = user;
        }

        private User currentUser;
        private List<UserData> children = new ArrayList<>();

        public void setChildren(List<UserData> children) {
            this.children = children;
        }

        public void setCurrentUser(User currentUser) {
            this.currentUser = currentUser;
        }

        public List<UserData> getChildren() {
            return children;
        }

        public User getCurrentUser() {
            return currentUser;
        }

        class SourceIter implements Iterator<UserData> {
            private UserData next;
            private Iterator<UserData> childrenIterator;
            private Iterator<UserData> current;
            SourceIter(UserData userData) {
                this.next = userData;
                this.childrenIterator = getChildren().iterator();
                this.current = Collections.emptyIterator();
            }

            @Override
            public boolean hasNext() {
                return fetchNext()!=null;
            }

            @Override
            public UserData next() {
                UserData userData = fetchNext();
                this.next = null;
                return userData;
            }

            UserData fetchNext() {
                // 把找到的下一个返回
                if (this.next != null) {
                    return this.next;
                }
                // 当前的遍历器
                if (this.current.hasNext()) {
                    this.next = this.current.next();
                    return this.next;
                }
                // 子类每个对象走一遍自定义遍历器
                if (this.childrenIterator.hasNext()) {
                    this.current =  this.childrenIterator.next().iterator();
                    // 只有用递归才会走当前的遍历器
                    return  fetchNext();
                }
                return null;
            }
        }

        @Override
        public Iterator<UserData> iterator() {
            return new SourceIter(this);
        }
    }

    public static void main(String[] args) {
        UserData userData = new UserData(new User("user1"));
        UserData userData2 = new UserData(new User("user2"));
        UserData userData3 = new UserData(new User("user3"));
        UserData userData4 = new UserData(new User("user4"));
        UserData userData5 = new UserData(new User("user5"));
        List<UserData> userDataList = new ArrayList<>(){
            {
                add(userData2);
            }
        };
        List<UserData> userDataList2 = new ArrayList<>(){
            {
                add(userData3);
                add(userData4);
            }
        };
        List<UserData> userDataList3 = new ArrayList<>(){
            {
                add(userData5);
            }
        };
        userData.setChildren(userDataList);
        userData2.setChildren(userDataList2);
        userData3.setChildren(userDataList3);

        Iterator<UserData> iterator = userData.iterator();
        while (iterator.hasNext()) {
            UserData next = iterator.next();
            System.out.println(next.getCurrentUser().name);
        }

    }
}
