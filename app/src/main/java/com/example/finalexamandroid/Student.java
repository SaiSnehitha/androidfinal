package com.example.finalexamandroid;

public class Student {
        private int stNo;
        private String stName;
        private String username;
        private String password;


    public Student(int stNo, String stName, String username, String password) {
        this.stNo = stNo;
        this.stName = stName;
        this.username = username;
        this.password = password;
    }

        public int getStNo() {
        return stNo;
    }

        public String getStName() {
        return stName;
    }

        public String getUsername() {
        return username;
    }

        public String getPassword() {
        return password;
    }

}
