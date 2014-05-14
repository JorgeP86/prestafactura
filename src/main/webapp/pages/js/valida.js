

//  
//  Descripcion: Funciones standares para validar campos
//

//-----------------------------------------------------------------------------               

//
// Funcion validaFecha(dia, mes, anno)
// Entrada:
//    dia	cadena	Dia del mes
//    mes	cadena	Mes del año
//    anno	cadena	Año
// Salida: booleano 	Verdadero si la fecha es correcta, falso en caso contrario
//



function validaFecha(dia,mes,anno)
{
  var d,m,a;

    if(dia=="" || isNaN(dia))
      return false;
       
    d=eval(dia);
    if(d<1 || d>31) 
      return false;
      
    if(mes=="" || isNaN(mes))
       return false;
    
    m=eval(mes);
    if(m<1 || m>12)
       return false;
       
    if(anno=="" || isNaN(anno) || anno.length!=4)
       return false;
   
    a=eval(anno);
    if(d>diasMes(m,a))
       return false;
         
    return true;
}

function diasMes(mes,anno)
{
  var meses=[31,28,31,30,31,30,31,31,30,31,30,31];
  var dias=meses[mes-1];
   
    if((mes==2) && ((anno % 400)==0 || ((anno % 4)==0 && (anno % 100)!=0)))
      dias=29;
	
    return dias;
}

//
// Funcion validaCuenta(entidad,oficina,dc,numcuenta)
// Entrada:
//    entidad	cadena	Entidad (4 dígitos)
//    oficina	cadena	Oficina (4 dígitos)
//    dc	cadena	Digito de control (2 dígitos)
//    numcuenta cadene  Número de cuenta (10 dígitos)
// Salida: booleano 	Verdadero si el CCC es correcto, falso en caso contrario
//
function validaCuenta(entidad,oficina,dc,numcuenta)
{
  var cuenta;
  var tabla_pesos=[4,8,5,10,9,7,3,6,0,0,1,2,4,8,5,10,9,7,3,6];
  var val_dig1=0;
  var val_dig2=0;
  var vuelta=0;
    
    cuenta = entidad + oficina + dc + numcuenta;
	
    if(cuenta.length!=20) 
      return false;
      
    if(cuenta=="00000000000000000000") 
      return false;
      
    if(isNaN(cuenta)) 
      return false;
      
    for(i=0;i<8;i++) 
       val_dig1+= eval(cuenta.substr(i,1)) * tabla_pesos[i];       
    for(i=10;i<20;i++) 
       val_dig2+= eval(cuenta.substr(i,1)) * tabla_pesos[i];

    val_dig1=11-val_dig1 % 11;
    if(val_dig1==10) 
       val_dig1=1;       
    if(val_dig1==11) 
       val_dig1=0;
    val_dig2=11-val_dig2 % 11;
    if(val_dig2==10)
       val_dig2=1;
    if(val_dig2==11) 
       val_dig2=0;
       
    if( cuenta.substr(8,2)!=''+val_dig1+val_dig2) 
       return false;
       
    return true;
}

//
// Funcion validaNIFCIF(nif_cif)
// Entrada:
//    nif_cif	cadena	NIF o CIF
// Salida: booleano 	Verdadero si el NIF o CIF es correcto, falso en caso contrario
//
function validaNIFCIF(nif_cif_may)
{var letrasNIF="TRWAGMYFPDXBNJZSQVHLCKE";
	
  var letra=nif_cif_may.substr(0,1);
  var nif_cif=nif_cif_may.toUpperCase();
 var nie;

  var dni,nPar,nImpar,i,n;

    if(!isNaN(letra) &&  nif_cif.length!=11)
    {
    
    	// NIF
	if(nif_cif.length!=9 && nif_cif.length!=11)
	  return false;
	  
	dni=nif_cif.substr(0,8);
	if(isNaN(dni))
	   return false;
	   
	dni=eval(dni) % 23;
	if(letrasNIF.substr(dni,1)!=nif_cif.substr(8,1)) 
	   return false;
	   
	return true;
    }
    else if(nif_cif.length==9 && isNaN(nif_cif.substr(0,1)))
    {
   //NIE
   nie=nif_cif.substr(1,9);
   if(isNaN(nie))
   	return false;
   	
   	return true;
   	}
   	else if(nif_cif.length==11 && !isNaN(nif_cif))
   		return true;
   	
   
   
	   
	//return true;
    
}

//
// Funcion validaCorreo(correo)
// Entrada:
//    correo	cadena	Cadena que contiene la dirección email que se tiene que
//                      verificar
// Salida: booleano 	Verdadero si la direccion es correcta, falso en caso contrario
//


function validaCorreo(correo)
{
  var pos;
  
   if((pos = correo.indexOf("@")) < 0)
     return false;
   else
     if(correo.indexOf(".",pos) <= pos + 1)
       return false;
     else
       if(correo.substr(correo.lastIndexOf(".")).length > 2)
           return true;
        else 
           return false;
}
//-----------------------------------------------------------------------------               

//
// Funcion radioSeleccionado(radio)
// Entrada:
//    radio 	array de radiobutton
// Salida: entero 	radiobutton seleccionado ó -1 si no hay ninguno seleccionado
//
function radioSeleccionado(radio) {
	for(k=0;k<radio.length;k++)
		if(radio[k].checked) return k;
       return -1;
}

//-----------------------------------------------------------------------------               

//
// Funcion checkboxSeleccionado(checkbox)
// Entrada:
//    checkbox 	array de checkbox
// Salida: entero 	checkbox seleccionado ó -1 si no hay ninguno seleccionado
//
function checkboxSeleccionado(checkbox) {
	for(k=0;k<checkbox.length;k++)
		if(checkbox[k].checked) return k;
       return -1;
}


//-------------------------------------------------------------------------------

//Funcion validaRangoFecha

function validaRangoFecha(anno1,mes1,dia1,anno2,mes2,dia2)
{
   var result=true;

   if (anno1==anno2)
   {
      if (mes1==mes2)
      {
         if (dia1>=dia2)
         {
            result=false;
         }
      }
      else if (mes1>mes2)
      {
         result=false;
      }
   }
   else if (anno1>anno2)
   {
      result=false;
   }
return result;
}


//-----------------------------------------------------------------------------

//
//Function isEmpty(cadena)
//Entrada: cadena String
//Salida: boolean true si la cadena está vacía ó false si no lo está
//
function isEmpty(cadena) {
    var i;
    for(i=0;i<cadena.length;i++)
        if(cadena[i] != ' ') return false;

    return true;
}
//-----------------------------------------------------------------------------

//Function parteFecha(cadena)
//Entrada: cadena String
//Salida: Tres String con el dia el mes y el año
//
var diasa,messa,anyosa;
var h,m;
var diap,mesp,anyop;
var diak,mesk,anyok;

function parteFecha(cadena){
		
		var n=cadena.indexOf('/');
		var m;
		var f2;
		if(n!=-1){
			diasa=cadena.substring(0,n);//dia
			f2=cadena.substring(n+1,cadena.length);//resto fecha menos el día
			m=f2.indexOf('/');
			if(m!=-1){
				messa=f2.substring(0,m);//mes
				anyosa=f2.substring(m+1,f2.length);//anyo
				
				
			}
		
		}
			else{
				diasa=null;
				messa=null;
				anyosa=null;
		
		
		
		}
}




function parteFecha2(cadena){
		
		var n=cadena.indexOf('/');
		var m;
		var f2;
		if(n!=-1){
			diap=cadena.substring(0,n);//dia
			f2=cadena.substring(n+1,cadena.length);//resto fecha menos el día
			m=f2.indexOf('/');
			if(m!=-1){
				mesp=f2.substring(0,m);//mes
				anyop=f2.substring(m+1,f2.length);//anyo
				
				
			}
		
		}
			else{
				diap=null;
				mesp=null;
				anyop=null;
		
		
		
		}
		
		
}


function parteFecha3(cadena){
		
		var n=cadena.indexOf('/');
		var m;
		var f2;
		if(n!=-1){
			diak=cadena.substring(0,n);//dia
			f2=cadena.substring(n+1,cadena.length);//resto fecha menos el día
			m=f2.indexOf('/');
			if(m!=-1){
				mesk=f2.substring(0,m);//mes
				anyok=f2.substring(m+1,f2.length);//anyo
				
				
			}
		
		}
			else{
				diak=null;
				mesk=null;
				anyok=null;
		
		
		
		}
		
		
}
var dial,mesl,anyol;

function parteFecha4(cadena){
		
		var n=cadena.indexOf('/');
		var m;
		var f2;
		if(n!=-1){
			dial=cadena.substring(0,n);//dia
			f2=cadena.substring(n+1,cadena.length);//resto fecha menos el día
			m=f2.indexOf('/');
			if(m!=-1){
				mesl=f2.substring(0,m);//mes
				anyol=f2.substring(m+1,f2.length);//anyo
				
				
			}
		
		}
			else{
				dial=null;
				mesl=null;
				anyol=null;
		
		
		
		}
		
		
}

var mesg,diag,anyog;
function parteFecha6(cadena){

		
		
		var n=cadena[0].value.indexOf('/');
		var m;
		var f2;
		if(n!=-1){
			dial=cadena[0].value.substring(0,n);//dia
			f2=cadena[0].value.substring(n+1,cadena[0].value.length);//resto fecha menos el día
			m=f2.indexOf('/');
			if(m!=-1){
				mesg=f2.substring(0,m);//mes
				anyog=f2.substring(m+1,f2.length);//anyo
				
				
			}
		
		}
			else{
				diag=null;
				mesg=null;
				anyog=null;
		
		
		
		}
		
		
}






var diaf,mesf,anyof;

function parteFecha5(cadena){
		
		var n=cadena.indexOf('/');
		
		var m;
		var f2;
		if(n!=-1){
			diaf=cadena.substring(0,n);//dia
			
			f2=cadena.substring(n+1,cadena.length);//resto fecha menos el día
			m=f2.indexOf('/');
			if(m!=-1){
				mesf=f2.substring(0,m);//mes
				anyof=f2.substring(m+1,f2.length);//anyo
				
				
			}
		
		}
		else{
				diaf=null;
				mesf=null;
				anyof=null;
		
		
		
		}
	
		
		
}



//Funcion validaArrayRadio(array[])
//Entrada array[]
//Salida boolean
//
function validaArrayRadio(array){
	var i;
	var enc=false;
	//alert(array.length);
	for(i=0;i<array.length && !enc;i++){
		if(array[i].checked)
			enc=true;
	
	
	
	}
	return enc;
}


function validaEdadHijos(numero,array){
		var enc=false;
		var i;
	
		for(i=0;i<numero && !enc  ;i++){
		
		if(isNaN(array[i].value))
		enc=true;
		}

	return enc;

}

function trim(cadena)
{
var enc=false;
var mal="";
	for(i=0; i<cadena.length; )
	{
		if(cadena.charAt(i)==" "){
		enc=true;
			cadena=cadena.substring(i+1, cadena.length);
			}
		else
			break;
	}
	if(enc)
	return mal;
		

	for(i=cadena.length-1; i>=0; i=cadena.length-1)
	{
		if(cadena.charAt(i)==" ")
			cadena=cadena.substring(0,i);
		else
			break;
	}
	return cadena;
//document.getElementById('perfil1').value=cadena;
}

//Validacion array telefonos

function validaArrayTelefonos(array){
	var correcto=true;
	var i;
	
	if(array.length==0){
	
		if(trim(array.value)!=""){
			
			if(isNaN(array.value)){
				correcto=false;
			}	
		}
	}else{
		
		for(i=0;i<array.length && correcto;i++){
				
			if( trim(array[i].value)!=""){
			
				if(isNaN(array[i].value)){
					
					correcto=false;
				}	
			}
		}
	
	}
		
	return correcto;	
}
//validacion fechaNacimiento familia

function validaFechaFamilia(array){
	
	var correcto=true;
	var i;
	
	if(array.length==0){
		//correcto=true;
		if (array.value!=''){

		parteFecha5(array.value);
		
			if(!validaFecha(diaf,mesf,anyof)){
				correcto=false;
			}
		}
	}
	else{
	
		for(i=0;i<array.length && correcto;i++){
	
			if( trim(array[i].value)!=""){
				
				parteFecha5(array[i].value);
		
				if(!validaFecha(diaf,mesf,anyof)){
					correcto=false;
				}	
			}
		}
	
	}
	return correcto;
}

//validacion fecha formato: dd/mm/aaaa hh:mm
function validaFechaHora(cadena){
		var correcto=true;
		
		var n=cadena.indexOf(' ');
		var fecha;
		var hora;
	
		if(n!=-1 ){
			fecha=cadena.substring(0,n);//fecha
			hora=cadena.substring(n+1,cadena.length);//hora
			parteFecha(fecha);
			var phora=parteHora(hora);
			
			if(!validaFecha(diasa,messa,anyosa)){
				correcto=false;
			}
			else if(!validaHora(h,m) || !phora){
				correcto=false;
			}
			
		
		}
		else{
			correcto=false;
		
		}
		
		return correcto;
	

}


//partir la hora
function parteHora(cadena){
	var n=cadena.indexOf(':');
	var correcto=true;
	h=null;
	m=null;
	if(n!=-1){
	h=cadena.substring(0,n);
	m=cadena.substring(n+1,cadena.length);
	
		
	}
	else if(h==null || m==null)
	correcto=false;
	else{
	correcto=false;
	
	}

return correcto;


}



//validacion hora
function validaHora(h,m){
//|| (min.length!=2)


		var correcto=true;
		if(m==null || h==null)
		correcto=false;
	else if((h<0) || (h>23) || (m<0) || (m>59)  || isNaN(h) || isNaN(m) || trim(m)==""  || trim(h)=="" )
		correcto=false;
		return correcto;
		


}

function validaTelefonoDeseado(array){

	var correcto=true;
	var i;
	
	if(array.length==0)
		correcto=true;
	else{
	for(i=0;i<array.length && correcto;i++){
		if(array[i].value!=null || trim(array[i].value)!=""){
			
			if(isNaN(array[i].value)){
				correcto=false;
			}
		
	}

}
}
return correcto;
}



function validaTelefonoNoDeseado(array){

		var correcto=true;
	var i;

	if(array.length==0)
		correcto=true;
	else{
	for(i=0;i<array.length && correcto;i++){
		if(array[i].value!=null || trim(array[i].value)!=""){
			
			if(isNaN(array[i].value)){
				correcto=false;
			}
		
	}

}
}
return correcto;
}

		
function validaNifs(array){

	var correcto=true;
	var i;
	
	if(array.length==0)
		correcto=true;
	else{
	for(i=0;i<array.length && correcto;i++){
		if(array[i].value!=null || trim(array[i].value)!=""){
			
			if(!validaNIFCIF(array[i].value)){
				correcto=false;
			}
		
	}

}
}
return correcto;
}		
		
		
function validaFechaSeguimiento(num,array){
	var correcto=true;
	var i;

	if(array.length==0)
		correcto=true;
	else{
	for(i=0;i<num && correcto;i++){
		if(array[i].value!=null || trim(array[i].value)!=""){
	parteFecha6(array[i].value);
			if(!validaFecha(diag,mesg,anyog)){
				correcto=false;
			}
			}
			}
			}
			return correcto;

}












