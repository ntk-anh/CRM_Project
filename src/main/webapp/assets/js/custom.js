
// thư viện toastr => hiện thông báo
toastr.options = {
  "closeButton": false,
  "debug": false,
  "newestOnTop": false,
  "progressBar": false,
  "positionClass": "toast-top-right",
  "preventDuplicates": false,
  "onclick": null,
  "showDuration": "300",
  "hideDuration": "1000",
  "timeOut": "5000",
  "extendedTimeOut": "1000",
  "showEasing": "swing",
  "hideEasing": "linear",
  "showMethod": "fadeIn",
  "hideMethod": "fadeOut"
}
function showToastr(type,message){
	toastr[type](message);
}
//end toastr
$(document).ready(function () {			
            $(function () {
                $(".preloader").fadeOut();
                $('#side-menu').metisMenu();
            });

            //Loads the correct sidebar on window load,
            //collapses the sidebar on window resize.
            // Sets the min-height of #page-wrapper to window size
            $(function () {
                $(window).bind("load resize", function () {
                    topOffset = 60;
                    width = (this.window.innerWidth > 0) ? this.window.innerWidth : this.screen.width;
                    if (width < 768) {
                        $('div.navbar-collapse').addClass('collapse');
                        topOffset = 100; // 2-row-menu
                    } else {
                        $('div.navbar-collapse').removeClass('collapse');
                    }
                    height = ((this.window.innerHeight > 0) ? this.window.innerHeight : this.screen.height) - 1;
                    height = height - topOffset;
                    if (height < 1) height = 1;
                    if (height > topOffset) {
                        $("#page-wrapper").css("min-height", (height) + "px");
                    }
                });
                var url = window.location;
                var element = $('ul.nav a').filter(function () {
                    return this.href == url || url.href.indexOf(this.href) == 0;
                }).addClass('active').parent().parent().addClass('in').parent();
                if (element.is('li')) {
                    element.addClass('active');
                }
            });
            // This is for resize window
            $(function () {
                $(window).bind("load resize", function () {
                    width = (this.window.innerWidth > 0) ? this.window.innerWidth : this.screen.width;
                    if (width < 1170) {
                        $('body').addClass('content-wrapper');
                        $(".open-close i").removeClass('icon-arrow-left-circle');
                        $(".sidebar-nav, .slimScrollDiv").css("overflow-x", "visible").parent().css("overflow", "visible");
                        $(".logo span").hide();
                    } else {
                        $('body').removeClass('content-wrapper');
                        $(".open-close i").addClass('icon-arrow-left-circle');
                        $(".logo span").show();
                    }
                });
            });
            // This is for click on open close button
            // Sidebar open close
            $(".open-close").on('click', function () {
                if ($("body").hasClass("content-wrapper")) {
                    $("body").trigger("resize");
                    $(".sidebar-nav, .slimScrollDiv").css("overflow", "hidden").parent().css("overflow", "visible");
                    $("body").removeClass("content-wrapper");
                    $(".open-close i").addClass("icon-arrow-left-circle");
                    $(".logo span").show();
                } else {
                    $("body").trigger("resize");
                    $(".sidebar-nav, .slimScrollDiv").css("overflow-x", "visible").parent().css("overflow", "visible");
                    $("body").addClass("content-wrapper");
                    $(".open-close i").removeClass("icon-arrow-left-circle");
                    $(".logo span").hide();
                }
            });

            // Sidebar
            $('.slimscrollright').slimScroll({
                height: '100%',
                position: 'right',
                size: "5px",
                color: '#dcdcdc',
            });
            $('.slimscrollsidebar').slimScroll({
                height: '100%',
                position: 'right',
                size: "0px",
                color: '#dcdcdc',
            });
            $('.chat-list').slimScroll({
                height: '100%',
                position: 'right',
                size: "0px",
                color: '#dcdcdc',
            }); 
            
			//hiện thông báo dùng thư viện toast
	        if($('#toastrResult').val()=='insertSuccess'){
				showToastr('success','Thêm mới thành công');
			}else if($('#toastrResult').val()=='insertError'){
				showToastr('error','Thêm mới thất bại');
			}else if($('#toastrResult').val()=='updateSuccess'){
				showToastr('success','Cập nhật thành công');
			}else if($('#toastrResult').val()=='updateError'){
				showToastr('error','Cập nhật thất bại');
			}else if($('#toastrResult').val()=='deleteSuccess'){
				showToastr('success','Xóa thành công');
			}else if($('#toastrResult').val()=='deleteError'){
				showToastr('error','Xóa thất bại');
			}else if($('#toastrResult').val()=='loginError'){
				showToastr('error','Login thất bại! Email hoặc mật khẩu không đúng.');
			}
			
            // Resize all elements
            $("body").trigger("resize");
            // visited ul li
            $('.visited li a').click(function (e) {
                $('.visited li').removeClass('active');
                var $parent = $(this).parent();
                if (!$parent.hasClass('active')) {
                    $parent.addClass('active');
                }
                e.preventDefault();
            });
            
            
});
