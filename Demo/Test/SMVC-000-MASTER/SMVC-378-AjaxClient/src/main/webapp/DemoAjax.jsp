<!DOCTYPE html>
<html>
  <head>
    <title>WebSocket Chat</title>
    <link href="${pageContext.request.contextPath}/webjars/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">    
    <script src="${pageContext.request.contextPath}/webjars/jquery/3.1.0/jquery.min.js"></script>   
    <link href="main.css" rel="stylesheet">
    <script src="DemoAjax.js"></script>
  </head>
<body>

  <div id="main-content" class="container">
     <br/>
     <br/>
     <br/>
     
     <div class="row">
       <label for="from">Demo Ajax Request</label>
     </div>
     
      <br/>
      
     <div class="row">
     	  <label for="from">Request</label>
	      <div class="col-md-12 space-bottom10">
	         <form class="form-inline">
	          <div class="form-group">
	          	Service uri: <input type="text" id="testUrl" class="form-control" placeholder="uri..">	
	          	<button id="sendGetRequest"    class="btn btn-default" type="submit">Send Request</button>   
	          </div>  	          
			</form>
	      </div>      
    	</div>
    	
	     <br/>
	     <br/>
	     <br/>
		
		
	    <div class="row">
       		<label for="from">Responses</label>
       		
     	</div>
 
    
 	 </div>
  
</body>
</html>
