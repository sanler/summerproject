<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
<script src='/ytembed.js' type="text/javascript"></script>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

        <table class="table table-hover">
 							
                            <tbody>

                                <tr>
                                    <th>Title</th>
 									<th>Content</th>
                                </tr>
							 
                                <c:forEach var="blogs" items="${blogs}">
                                
						 
                                    <tr>
                                     
                                        <td><p class="flotante" date-identifier="${blogs.id}" data-toggle="tooltip" data-placement="right" title="" data-original-title="Tooltip on right"/>${blogs.title}</td>
										<td><p>${blogs.content}</p></td>
										
                                    </tr>
							
                                </c:forEach>
							
                            </tbody>

                        </table>

						<c:forEach var="psclaves" items="${psclaves}">
                                
						 
                                   <tr>
 
										<td><p>${psclaves}</p></td>
										
                                   </tr>
							
                                </c:forEach>
                                
                          <h2>palabras destacadas del contenido</h2>      
                          
                          	<c:forEach var="psclaves2" items="${psclaves2}">
                                
						 
                                   <tr>
 
										<td><p>${psclaves2}</p></td>
										
                                   </tr>
							
                                </c:forEach>
                                
                                <div id="youtubeDiv"></div>
                                <script src="http://www.yvoschaap.com/ytpage/ytembed.js" type="text/javascript"></script>
								<div id="ytThumbs"></div>

							<script type="text/javascript">
							ytEmbed.init({'block':'ytThumbs','q':'programacion','type':'search','results':1,'order':'most_relevance','player':'embed','layout':'full'});
							</script>

</body>
</html>
