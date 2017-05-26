<!DOCTYPE html>
<html>
<head>
  <link rel="stylesheet" href="..\css\styles.css">
  <link rel="stylesheet" href="..\css\w3.css">
  <!--<script type="text/javascript" src="../scripts/jquery.min.js"></script>-->
  <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>

</head>
<body>
<!-- Navbar -->
<div class="w3-top">
  <div class="w3-bar w3-black w3-card-2">
    <a class="w3-bar-item w3-button w3-padding-large w3-hide-medium w3-hide-large w3-right" href="javascript:void(0)" onclick="myFunction()" title="Toggle Navigation Menu"><i class="fa fa-bars"></i></a>
    <a href="#"  class="w3-bar-item w3-button w3-padding-large">HOME</a>
    <span class="w3-bar-item w3-right">
                        <img src="../images/Octane.png" height="30" width="100"/>
    </span>
  </div>
</div>
<br>


<br>
<br><br>
<br>

<div class="w3-container" align="center" style="background-color:white;">
  <h2>Planning Poker Session</h2>

  <div class="w3-card-4" style="width:90%" >
    <div class="w3-container">
	
	           <div class="w3-third" style="width:30%" align="center">
                <h5>List of Players</h5>
                <table class="w3-table w3-striped w3-white">
                    <tr>
                        <td>Marco Trachsel</td>
                        <td><i>Product Owner</i></td>
                    </tr>
                    <tr>
                        <td>Amir Khan</td>
                        <td><i>Developer</i></td>
                    </tr>
                    <tr>
                        <td>Andrej Rebernjak</td>
                        <td><i>Dev Lead</i></td>
                    </tr>
                </table>

            </div>

	  <div class="w3-third" style="width:5%" align="center">
		   <p></p>
	  </div>

	  <div class="w3-third" style="width:65%" align="center">
		   <p id="titlestory" name="titlestory">Poker Story No.</p>
		  <hr>
		  <img value="" src="../images/us.png" id="selectedOne" class="w3-left w3-circle w3-margin-right" style="width:60px" >
		  <p id="currentstory" name="currentstory">As an user i want to have the option to register a guest user access for logging into the application website with viewer access.</p><br>
	  </div>
	<button onclick="prevElements()" class="button" id="previous" style="background-color:DARKSLATEGRAY">Previous</button>
	<button onclick="nextElements()" class="button" id="next" style="background-color:DARKSLATEGRAY">Next</button>
	<button  class="button" id="submitselection" style="background-color:DARKSLATEGRAY">Submit Selection</button>
    </div>
<br>
<br>
  <div class="w3-row">
     <div class="w3-col w3-hover-shadow"  style="width:10%;background-color:#C0C0C0" >
      <img onclick="javascript:changeimg('../images/_1.png')" src="../images/_1.png" class="w3-circle" style="width:100%" id="first" >
    </div>
    <div class="w3-col w3-hover-shadow"  style="width:10%;background-color:DARKSLATEGRAY" >
      <img onclick="javascript:changeimg('../images/_2.png')" src="../images/_2.png" class="w3-circle" style="width:100%" alt="sun">
    </div>
    <div class="w3-col w3-hover-shadow"  style="width:10%;background-color:#C0C0C0" >
      <img onclick="javascript:changeimg('../images/_3.png')" src="../images/_3.png" class="w3-circle" style="width:100%" alt="sun">
    </div>
    <div class="w3-col w3-hover-shadow"  style="width:10%;background-color:DARKSLATEGRAY">
      <img onclick="javascript:changeimg('../images/_5.png')" src="../images/_5.png" class="w3-circle" style="width:100%" alt="sun">
    </div>
    <div class="w3-col w3-hover-shadow"  style="width:10%;background-color:#C0C0C0">
      <img onclick="javascript:changeimg('../images/_8.png')" src="../images/_8.png" class="w3-circle" style="width:100%" alt="sun">
    </div>
	
    <div class="w3-col w3-hover-shadow"  style="width:10%;background-color:DARKSLATEGRAY">
      <img onclick="javascript:changeimg('../images/_13.png')" src="../images/_13.png" class="w3-circle" style="width:100%" alt="sun">
    </div>
    <div class="w3-col w3-hover-shadow"  style="width:10%;background-color:#C0C0C0">
      <img onclick="javascript:changeimg('../images/_20.png')" src="../images/_20.png" class="w3-circle" style="width:100%" alt="sun">
    </div>
    <div class="w3-col w3-hover-shadow"  style="width:10%;background-color:DARKSLATEGRAY">
      <img onclick="javascript:changeimg('../images/_40.png')" src="../images/_40.png" class="w3-circle" style="width:100%" alt="sun">
    </div>
    <div class="w3-col w3-hover-shadow"  style="width:10%;background-color:#C0C0C0">
      <img onclick="javascript:changeimg('../images/_100.png')" src="../images/_100.png" class="w3-circle" style="width:100%" alt="sun">
    </div>
   <div class="w3-col w3-hover-shadow"  style="width:10%;background-color:DARKSLATEGRAY">
      <img onclick="javascript:changeimg('../images/coffee.png')" src="../images/coffee.png" class="w3-circle" style="width:100%" alt="sun">
    </div>


</div>
  <br>
  
</div>
<br>

<script type="text/javascript">
	var i=0;
	var responsedata = $.ajax({
		url: "http://localhost:8085/pp/pages/App/pages/work/bucket.txt",
		dataType: "txt",
		async: false
	}).responseText;
	var EachLineInTextFile = responsedata.split("�,");
	//alert(EachLineInTextFile);
	//document.getElementById("count").innerText = "Total stories loaded from ALM Octane: " + (EachLineInTextFile.length - 1)
	//for (var i = 1, len = EachLineInTextFile.length; i < len; i++) {
		//alert(EachLineInTextFile.length);
		if (EachLineInTextFile.length != 0) {
			//var StoryLists = EachLineInTextFile[i].split(";");
			document.getElementById("titlestory").innerText = "Poker Story No."  + i;
			document.getElementById("currentstory").innerText = EachLineInTextFile[i];
			//alert(EachLineInTextFile[i]);
			//alert(li.id);
			//alert(li.name);
			}
		//}

function changeimg(images) {
     document.getElementById('selectedOne').src=images;
 }

function nextElements() {
	i=i+1;
	if (i!=42) {
		document.getElementById("titlestory").innerText = "Poker Story No."  + (i+1);
		document.getElementById("currentstory").innerText = EachLineInTextFile[i];
		document.getElementById("previous").disabled=false;
	}
	else {
    i=41;
	document.getElementById("next").disabled=true;
	}
}
	
function prevElements() {
	i=i-1;
	if (i>=0) {
		document.getElementById("next").disabled=false;
		document.getElementById("titlestory").innerText = "Poker Story No. "  + (i+1);
		document.getElementById("currentstory").innerText = EachLineInTextFile[i];
	}
	else {
    i=0;
	document.getElementById("previous").disabled=true;
	}
}

</script>

</body>
</html>
