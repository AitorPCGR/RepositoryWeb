 import java.io.IOException;
    import java.io.PrintWriter;
    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.SQLException;
    import java.sql.Statement;

    import javax.servlet.ServletException;
    import javax.servlet.http.HttpServlet;
    import javax.servlet.http.HttpServletRequest;
    import javax.servlet.http.HttpServletResponse;

    public class Authentication extends HttpServlet {
        private static final long serialVersionUID = 1L;

        public Authentication() {
            super();
        }
        protected void doGet(HttpServletRequest request,
                HttpServletResponse response) throws ServletException, IOException {

        }

        protected void doPost(HttpServletRequest request,
                HttpServletResponse response) throws ServletException, IOException {

            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            String username = request.getParameter("username");
            String pass = request.getParameter("pass");

            String sql = "select * from reg where username='" + username + "'";
            Connection conn = null;

            try {
                conn = DriverManager.getConnection("jdbc:mysql://localhost/Exam",
                        "root", "");
                Statement s = conn.createStatement();

                java.sql.ResultSet rs = s.executeQuery(sql);
                String un = null;
                String pw = null;
                String name = null;

            /* Need to put some condition in case the above query does not return any row, else code will throw Null Pointer exception */   

            PrintWriter prwr1 = response.getWriter();               
            if(!rs.isBeforeFirst()){
                prwr1.write("<h1> No Such User in Database<h1>");

/* Conditions to be executed after at least one row is returned by query execution */ 
                while (rs.next()) {
                    un = rs.getString("username");
                    pw = rs.getString("password");
                    name = rs.getString("name");
                }

                PrintWriter pww = response.getWriter();

                if (un.equalsIgnoreCase(username) && pw.equals(pass)) {
                                // use this or create request dispatcher 
                    response.setContentType("text/html");
                    pww.write("<h1>Welcome, " + name + "</h1>");
                } else {
                    pww.write("wrong username or password\n");
                }

            }} catch (SQLException e) {
                e.printStackTrace();
            }

        }}

    

