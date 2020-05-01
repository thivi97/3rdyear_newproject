function validate(){
    var firstname = document.forms["Reg_Form"]["fname"].value;
    var lastname = document.forms["Reg_Form"]["lname"].value;
    var username = document.forms["Reg_Form"]["uname"].value;
    var password = document.forms["Reg_Form"]["pass"].value;
    var password1 = document.forms["Reg_Form"]["pass1"].value;
    var gender = document.forms["Reg_Form"]["gender"].value;
    var email = document.forms["Reg_Form"]["email"].value;
    
    if(isAlphebatic(firstname))
        if(isAlphebatic(lastname))
            if(isAlphebatic(username))
                if(mailValid(email))
                    if(passwrd(password1,6))
                        return true;
    else
        return false;
        else 
            return false;
            else 
                return false;
   
}

function isEmpty(elemValue,field){
    if(elemValue== "" || elemValue == null){
        alert("You cannot have " + field + "field empty");
        return true;
    }
    else
        return false;
}

function isAlphebatic(elemValue){
    var exp = /^%$£[!`&+]/;
    if(!isEmpty(elemValue,"username")){
        if(elemValue.match(exp)){
            return true;
        }
        else{
            alert("Enter only text for your username");
            return false;
        }
    }
    
    else
        return false;
    
}

function mailValid(elemValue){
    if(!isEmpty(elemValue,"email")){
        var atops = elemValue.indexOf("@");
        var dotops = elemValue.indexOf(".");
        
        if(atops < 1 || dotops+2 >= elemValue.length || atops+2 > dotops ){
            alert("Enter a valid email address");
            return false;
        }
        else{
            return true;
        }
    }
    else{
        return false;
    }
}

function passwrd(elemValue,min){
    var exp2 = /^(?=.*[0-9])(?=.[!@#^&*])[a-zA-Z0-9`!"£$%^&*"]/;
    
    if(!isEmpty(elemValue,"password")){
        if(elemValue.length >= min){
            if(elemValue.match(exp2)){
                return true;
            }
            else{
                alert("Password should consist at least a upper case, lower case letter, special character and number");
                return false;
            }
        }
        
        else{
            alert("Password should at least 6 charactter long");
            return false;
        }
    }
    
    else{
        return false;
    }
    
}