$(function() {
	var Accordion = function(el, multiple) {
		this.el = el || {};
		this.multiple = multiple || false;

		var links = this.el.find('.link');

		links.on('click', {el: this.el, multiple: this.multiple}, this.dropdown);
	}

	Accordion.prototype.dropdown = function(e) {
		var $el = e.data.el;
			$this = $(this),
			$next = $this.next();

		$next.slideToggle();
		$this.parent().toggleClass('open');

		if (!e.data.multiple) {
			$el.find('.submenu').not($next).slideUp().parent().removeClass('open');
		};
	}	
    

	var accordion = new Accordion($('#accordion2'), false);
	var accordion = new Accordion($('#accordion3'), false);
	var accordion = new Accordion($('#accordion4'), false);
	var accordion = new Accordion($('#accordion5'), false);
	var accordion = new Accordion($('#accordion6'), false);
	var accordion = new Accordion($('#accordion7'), false);
	var accordion = new Accordion($('#accordion8'), false);
	var accordion = new Accordion($('#accordion9'), false);
	var accordion = new Accordion($('#accordion10'), false);
	var accordion = new Accordion($('#accordion11'), false);
	var accordion = new Accordion($('#accordion12'), false);
	var accordion = new Accordion($('#accordion13'), false);
	var accordion = new Accordion($('#accordion14'), false);
	var accordion = new Accordion($('#accordion15'), false);
	var accordion = new Accordion($('#accordion16'), false);
	
});