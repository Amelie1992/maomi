function changeBiao(obj,sType)
		{
			var form = document.forms['form1'];
			if('2'==sType)
			{
				form.action = './hotsubject/s/queryhotsubject';
			}
			else if('1'==sType)
			{
				form.action = './subject/s/querysubject';
			}
			else if('0'==sType)
			{
				form.action = './subject/s/querynewsubject';
			}
			else if('4'==sType)
			{
				form.action = './subject/s/queryhighsubject';
			}
			else if("5"==sType)
			{
				form.action = './bondTransfer/getBondTransfer';
			}
			else if("6"==sType)
			{
				form.action = './freedomsubject/s/queryfreedomsubject';
			}
			else if("7"==sType)
			{
				form.action = './crowdfund/s/querycrowfund';
			}
			form.submit();
		}

	//投资
	function investNow(id)
	{
		var form = document.forms['form1'];
		$("#freedomSubjectId").val(id);
		form.action = './freedomsubject/s/detailfreedomsubject';
		form.submit();
	}