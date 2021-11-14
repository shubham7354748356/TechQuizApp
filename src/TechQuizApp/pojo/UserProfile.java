/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TechQuizApp.pojo;

/**
 *
 * @author india
 */
public class UserProfile {

    public static String getUserNameInProfile() {
        return userNameInProfile;
    }

    public static  String getUserTypeInProfile() {
        return userTypeInProfile;
    }

    public static void setUserNameInProfile(String userNameInProfile1) {
        userNameInProfile = userNameInProfile1;
    }

    public static void setUserTypeInProfile(String userTypeInProfile1) {
        userTypeInProfile = userTypeInProfile1;
    }

   
    private static String userNameInProfile;
    private static String userTypeInProfile;
    
}
