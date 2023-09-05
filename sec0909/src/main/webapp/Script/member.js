function joinCheck() {
	if(document.frm.userid.value.length < 4){
		alert("아이디는 4글자 이상이어야 합니다.")
		frm.userid.focus();
		return false;
	}
	
	if(document.frm.pwd.value != document.frm.pwd_check.value){
		alert("비밀번호가 일치하지 않습니다.")
		frm.pwd.focus();
		return false;
	}
	
	if(document.frm.reid.value.length == 0){
		alert("아이디 중복 체크를 해 주세요.")
		return false;
	}
	
	return true;
}


function idCheck(){
	if(document.frm.userid.value.length == 0){
		alert("아이디를 입력해주세요")
		frm.userid.focus();
		return false;
	}
	
	let url = "idCheck.do?userid=" + document.frm.userid.value;
	window.open(url, "_blank", "width=700, height=400, toolbar=no, menubar=no, scrollbars=yes, resizeable=no");
}

function idok(){
	opener.frm.userid.value = document.frm.userid.value;
	opener.frm.reid.value = document.frm.userid.value;
	self.close();
}