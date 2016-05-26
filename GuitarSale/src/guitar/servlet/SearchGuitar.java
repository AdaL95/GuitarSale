  package guitar.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import DBconnection.DBconn;
import guitar.m.Guitar;


/**
 * Servlet implementation class SearchGuitar
 */
@WebServlet("/SearchGuitar")
public class SearchGuitar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchGuitar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    request.setCharacterEncoding("UTF-8");
	    response.setContentType("text/html;charset=UTF-8");
	    
		String type=request.getParameter("type");
		String price=request.getParameter("price");
		String builder=request.getParameter("builder");
		String backwood=request.getParameter("backwood");
		String topwood=request.getParameter("topwood");
		
	
			
		Connection conn=null;
		Statement statement=null;
		ResultSet result=null;
		SQLException ex=null;
		List<Guitar> guitars=null;
		
		String a=null;
		if(!type.equals("")){
			a="select type,price,builder,backwood,topwood FROM Guitar WHERE type=?";
		}
		if(!price.equals("")){
			a="select type,price,builder,backwood,topwood FROM Guitar WHERE price=?";
		}
		if(!builder.equals("")){
			a="select type,price,builder,backwood,topwood FROM Guitar WHERE builder=?";
		}
		if(!backwood.equals("")){
			a="select type,price,builder,backwood,topwood FROM Guitar WHERE backwood=?";
			
		}
		if(!topwood.equals("")){
			a="select type,price,builder,backwood,topwood FROM Guitar WHERE topwood=?";
		}
		if(!topwood.equals("")){
			a="select type,price,builder,backwood,topwood FROM Guitar WHERE type=? and price=?";
		}
		if(!topwood.equals("")){
			a="select type,price,builder,backwood,topwood FROM Guitar WHERE type=? and price=? and builder=?";
		}
		if(!topwood.equals("")){
			a="select type,price,builder,backwood,topwood FROM Guitar WHERE type=? and price=? and builder=? and backwood=?";
			
		}
		if(!topwood.equals("")){
			a="select type,price,builder,backwood,topwood FROM Guitar WHERE type=? and price=? and builder=? and backwood=? and topwood=?";
		}
		try{
            DBconn b=new DBconn();
            conn=b.open();
			conn=DriverManager.getConnection(a);
			statement =conn.createStatement();
			result=statement.executeQuery("SELECT * FROM Guitar");
			guitars=new ArrayList<Guitar>();
			
			while (result.next()){
				Guitar guitar=new Guitar();
				guitar.setType(result.getString(1));
				guitar.setPrice(result.getString(2));
				guitar.setBuilder(result.getString(3));
				guitar.setBackwood(result.getString(4));
				guitar.setTopwood(result.getString(5));
				guitars.add(guitar);
			}
			}catch (SQLException e){
				ex=e;
			}finally{				
				if (statement!= null){
					try{
						statement.close();
					}
					catch(SQLException e){
						if(ex==null){
							ex=e;
						}
					}
					
				}
				if (conn!=null){
					try{
						conn.close();
					}
					catch(SQLException e){
						if(ex==null){
							ex=e;
						}
					}
				}
				if(ex!=null){
					throw new RuntimeException(ex);
				}
				
			}
		request.getRequestDispatcher("result.jsp").forward(request,response);
	
}

	

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
