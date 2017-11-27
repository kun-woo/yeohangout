package yeohangout.mysql;

import java.sql.Connection;

import javax.servlet.ServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import yeohangout.javabeans.UserAccount;

public class MyUtils {
	public static final String ATT_NAME_CONNECTION = "ATTRIBUTE_FOR_CONNECTION";
	public static final String ATT_NAME_USER_NAME = "ATTRIBUTE_FOR_STORE_USER_NAME_IN_COOKIE";
	
	private static MyUtils myUtils = null;
	private static HttpSession session = null;
	
	private MyUtils() {
		
	}
	
	public static MyUtils getMyUtils() {
		if(myUtils==null) {
			return new MyUtils(); 
		}
		
		return myUtils;
	}
	
	public static void setSession(HttpSession session2) {
		session = session2;
	}
	
	public static HttpSession getSession() {
		return session;
	}
	
	public static void deleteSession() {
		session = null;
	}
	 // Store Connection in request attribute.
    // (Information stored only exist during requests)
    public static void storeConnection(ServletRequest request, Connection conn) {
    		
        request.setAttribute(ATT_NAME_CONNECTION, conn);
    }
	
    // Get the Connection object has been stored in attribute of the request.
    public static Connection getStoredConnection(ServletRequest request) {
        Connection conn = (Connection) request.getAttribute(ATT_NAME_CONNECTION);
        return conn;
    }
    
 // Store user info in Session.
    public static void storeLoginedUser(HttpSession session, UserAccount loginedUser) {
    		setSession(session);
        // On the JSP can access via ${loginedUser}
        session.setAttribute("loginedUser", loginedUser);
    }
    
    public static UserAccount getLoginedUser(HttpSession session) {
        UserAccount loginedUser = (UserAccount) session.getAttribute("loginedUser");
        return loginedUser;
    }
    
    public static void storeUserCookie(HttpServletResponse response, UserAccount user) {
        System.out.println("Store user cookie");
        Cookie cookieUserName = new Cookie(ATT_NAME_USER_NAME, ""+user.getUserID());
        // 1 hour (Converted to seconds)
        cookieUserName.setMaxAge(1 * 60 * 60);
        response.addCookie(cookieUserName);
    }
    
    public static String getUserNameInCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (ATT_NAME_USER_NAME.equals(cookie.getName())) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }
    
    // Delete cookie.
    public static void deleteUserCookie(HttpServletResponse response) {
        Cookie cookieUserName = new Cookie(ATT_NAME_USER_NAME, null);
        // 0 seconds (This cookie will expire immediately)
        cookieUserName.setMaxAge(0);
        response.addCookie(cookieUserName);
    }
 
}
