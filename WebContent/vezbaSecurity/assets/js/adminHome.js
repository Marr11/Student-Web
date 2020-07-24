function setNumberOfRows(rows){
	console.log("Rows:" + rows);
	var now = new Date();
	var time = now.getTime();
	var expiratinTime = time + 24*1000*3600;
	now.setTime(expiratinTime);
	document.cookie = "rowsInTable=" + rows +";expires="+now.toGMTString();
}