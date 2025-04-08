package com.example.demo_pf;

public class SessionUser {
    public User logged_in_user;
    private static SessionUser instance;
    private SessionUser(){}

    public static SessionUser getInstance(){
        if(instance == null){
            instance = new SessionUser();
        }
        return instance;
    }

    public void setLogged_in_user(User user){
        logged_in_user = user;
    }

    public void log_out(){
        logged_in_user = null;
    }

    //for debugging only
    @Override
    public String toString(){
        if (logged_in_user == null) {
            return "No user is logged in.";
        }
        return (logged_in_user.isTeacher ? "Teacher" : "Student") + " : "
                + logged_in_user.firstname + " " + logged_in_user.lastname;
    }

}
