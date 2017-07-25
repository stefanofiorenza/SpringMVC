<!DOCTYPE html>
<html>
  <head>
    <title>WebSocket Chat</title>
    <link href="${pageContext.request.contextPath}/webjars/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">    
    <script src="${pageContext.request.contextPath}/webjars/jquery/3.1.0/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/webjars/sockjs-client/1.0.2/sockjs.min.js"></script>
    <script src="${pageContext.request.contextPath}/webjars/stomp-websocket/2.3.3/stomp.min.js"></script>
    <link href="${pageContext.request.contextPath}/resources/main.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/resources/DemoWebsocket.js"></script>
  </head>
<body>
  <div id="main-content" class="container">
   	<!-- <div class="row">
   		<div class="col-md-12 space-bottom10">
   		&nbsp;
   		</div>
     </div> -->
     <br/>
     <br/>
     <br/>
     <div class="row">
       <label for="from">Demo SockJs Websocket</label>
     </div>
      <br/>
     <div class="row">
     	  <label for="from">Connessione</label>
	      <div class="col-md-12 space-bottom10">
	         <form class="form-inline">
	          <div class="form-group">
	          	<button id="connect"    class="btn btn-default" type="submit">Connect</button>
	          	<button id="disconnect" class="btn btn-default" type="submit" disabled="disabled">Disconnect</button>
	          	<!-- <input type="text" id="subscribeToGroup" class="form-control" placeholder="subscribe.."> -->
	          	Topics
	          	<select name="subscribeTo" id="subscribeTo" class="form-control">
				    <option>messages</option>
				    <option>backend</option>				    
				    <option>destination1</option>
				    <option>destination2</option>
				    <option>destination3</option>
				</select>	             
	            <button id="subscribe" class="btn btn-default" type="submit">Subscribe</button>
	            <button id="unsubscribe" class="btn btn-default" type="submit" disabled="disabled">Unsubscribe</button>  
	          </div>  	          
			</form>
	      </div>      
    	</div>
	     <br/>
	     <br/>
	     <br/>
	     <div class="row">
       		<label for="from">Messages</label>
     	</div>
      <br/>
	    <div class="row">
		      <div class="col-md-12 space-bottom10">			    
		          <!-- 	<div class="form-group"> -->
		          	<div class="col-md-3">
			        	 <label for="from">From</label> 
			             <input type="text" id="from" class="form-control" placeholder="enter Name">
		            </div>	 
		            <div class="col-md-3">        
			             <label for="group">Group</label> 
			             <input type="text" id="group" class="form-control" placeholder="enter Group">
		             </div>	 
		             <div class="col-md-3">		             
			             <label for="message">Content</label>          
			             <input type="text" id="message" class="form-control" placeholder="enter some text">	
			         </div>	 
		            <div class="col-md-3">
						 <label for="serviceApi"> Service Api:</label>
						 <select name="serviceApi" id="serviceApi" class="form-control">
						 	    <option>incoming</option>
							    <option>routing</option>
							    <option>process</option>
							    <option>forward</option>
						  </select>	
			        </div>	
		     </div>  
		     <br/>
		<br/>
		      <div class="row" align="right">
		      	<button id="send" class="btn btn-default" type="submit">Send</button>
		      </div>  
		</div>  
   
	    <br/>
		<br/>
		<br/>
	    <div class="row">
       		<label for="from">Responses</label>
     	</div>
	     <br/>
	    <div class="row">
	      <div class="col-md-12">
	        <table id="conversation" class="table table-striped">
	          <thead>
	            <tr>
		      <th width="10%">From</th>
	          <th width="15%">To</th>
		      <th width="60%">Content</th>
		      <th width="10%">Time</th>
	            </tr>
	          </thead>
	          <tbody id="messages">
	          </tbody>
	        </table>
	      </div>
	    </div>
    
 	 </div>
  
</body>
</html>
