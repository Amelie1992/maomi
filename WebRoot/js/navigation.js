function toChange(obj,types)
  {
	  $(obj).addClass("currentChose");
	  if("1"==types)
	  {
		  window.location.href='./fontpage/s/queryFontPage';	
	  }
	  else if("2"==types)
	  {
		  window.location.href='./subject/s/querysubject';	
	  }
	  else if("3"==types)
	  {
		  window.location.href='./scoremarket/queryscoremarket';	
	  }
	  else if("4"==types)
	  {
		  window.location.href='./capital/querycapital';	
	  }
	  
  }
  
function useNows(types)
{
	  var rst=$("#rst").val();
	  if("1"==types)
	  {
		  window.location.href='./coupon/querycoupon';	
	  }
	  else if("2"==types)
	  {
		  window.location.href='./redpackage/toSavings';	
	  }
	  else if("3"==types)
	  {
		  if(rst=='isown')
		  {
			  alert("您未获得8.8元红包");
		  }
		  else
		  {
			  window.location.href='./coupon/querycoupon';	
		  }
	  }
	  else if("4"==types)
	  {
		  window.location.href='./loginregister/invitingfriends';	
	  }
	  else if("0"==types)
	  {
		  if(confirm("您还没有登录，是否立即登录"))
		  {
			  window.location.href='./loginregister/s/toLogin';	
		  }
	  }
	  else if("5"==types)
	  {
		  if(confirm("获取推荐码，请添加客服了解，是否立即添加?"))
		  {
			  window.location.href='./loginregister/s/goCustomer';	
		  }
	  }
}