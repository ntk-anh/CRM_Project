$(function(){
	$('.btn-edit-user').click(function(){
		var id=$(this).data("id");
		var url=$('#frmUser').att('action');
		$.ajax({
			url: link,
			type: 'post',
			dataType:'JSON',
			data:{
				id: id
			},
			success:function(result){
				$('#ho_ten').val(result.ho_ten);
				$('#email').val(result.email);
				$('#dia_chi').val(result.dia_chi);
				$('#so_dien_thoai').val(result.so_dien_thoai);
				$('.control__password').hide()
			},error:function(result){
				showToastr('error',error);
			}
		})
	})
});