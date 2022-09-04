-- drop database crm;
create database crm;
use crm;
-- có 5 table
create table role( -- table phân quyền
	id int auto_increment,
    ten_role varchar(100),
    mo_ta varchar(255),
    primary key (id)
);

create table trang_thai_cv(
	id int auto_increment,
    ten_trang_thai varchar(50),
    primary key(id)    
);

create table user(
	id int auto_increment,
    ho_ten varchar(255),
    email varchar(100),
    password varchar(50),
    dia_chi varchar(255),
    so_dien_thoai varchar(20),
    id_role int,
    primary key(id),
    foreign key (id_role) references role(id)
);

create table du_an(
	id int auto_increment,
    ten_du_an varchar(100),
    mo_ta varchar(255),
    ngay_bat_dau varchar(20),
    ngay_ket_thuc varchar(20),
    id_leader int,
    primary key(id) 
);

create table cong_viec(
	id int auto_increment,
    ten_cv varchar(255), 
    ngay_bat_dau varchar(20),
    ngay_ket_thuc varchar(20),
    id_du_an int,
    id_user_thuc_hien int,    
    id_trang_thai_cv int,
    primary key (id),
    foreign key (id_du_an) references du_an(id),
    foreign key (id_user_thuc_hien) references user(id),
    foreign key (id_trang_thai_cv) references trang_thai_cv(id)
);

-- Nhập liệu
insert into role (ten_role, mo_ta) values 
('Admin','Quản trị hệ thống'),
('Leader','Quản lý dự án'),
('Member','Nhân viên');

insert into trang_thai_cv (ten_trang_thai) values
('Chưa bắt đầu'),
('Đang thực hiện'),
('Đã hoàn thành');

insert into user (ho_ten, email, password, dia_chi, so_dien_thoai, id_role) values
('Nguyễn Thị A','nta@gmail.com','123','Phường 5 - TP.Mỹ Tho - Tiền Giang','0971438134',1),
('Nguyễn Thị B','ntb@gmail.com','123','Xã Trung An - TP.Mỹ Tho - Tiền Giang','0565142401',2),
('Nguyễn Thị C','ntc@gmail.com','123','Phường 9 - TP.Mỹ Tho - Tiền Giang','0121945176',2),
('Nguyễn Thị D','ntd@gmail.com','123','Phường 5 - TP.Mỹ Tho - Tiền Giang','0948605139',3),
('Nguyễn Thị E','nte@gmail.com','123','Xã Trung An - TP.Mỹ Tho - Tiền Giang','0948665139',3),
('Nguyễn Thị F','ntf@gmail.com','123','Xã Bình Đức - Huyện Châu Thành - Tiền Giang','0948455139',3),
('Nguyễn Thị G','ntg@gmail.com','123','Xã Bình Đức - Huyện Châu Thành - Tiền Giang','0948455139',3),
('Nguyễn Thị H','nth@gmail.com','123','Xã Bình Đức - Huyện Châu Thành - Tiền Giang','0948455139',3),
('Nguyễn Thị I','nti@gmail.com','123','Xã Bình Đức - Huyện Châu Thành - Tiền Giang','0948455139',3),
('Nguyễn Thị J','ntj@gmail.com','123','Xã Bình Đức - Huyện Châu Thành - Tiền Giang','0948455139',3),
('Nguyễn Thị K','ntk@gmail.com','123','Xã Bình Đức - Huyện Châu Thành - Tiền Giang','0948455139',3),
('Nguyễn Thị L','ntl@gmail.com','123','Xã Bình Đức - Huyện Châu Thành - Tiền Giang','0948455139',3),
('Nguyễn Thị M','ntm@gmail.com','123','Xã Bình Đức - Huyện Châu Thành - Tiền Giang','0948455139',3),
('Nguyễn Thị N','ntn@gmail.com','123','Xã Thân Cửu Nghĩa - Huyện Châu Thành - Tiền Giang','0333917493',3),
('Nguyễn Thị O','ntn@gmail.com','123','Xã Thân Cửu Nghĩa - Huyện Châu Thành - Tiền Giang','0333917493',3),
('Nguyễn Thị P','ntp@gmail.com','123','Xã Thân Cửu Nghĩa - Huyện Châu Thành - Tiền Giang','0333917493',3),
('Nguyễn Thị Q','ntq@gmail.com','123','Xã Thân Cửu Nghĩa - Huyện Châu Thành - Tiền Giang','0333917493',3),
('Nguyễn Thị R','ntr@gmail.com','123','Xã Thân Cửu Nghĩa - Huyện Châu Thành - Tiền Giang','0333917493',3),
('Nguyễn Thị S','nts@gmail.com','123','Xã Thân Cửu Nghĩa - Huyện Châu Thành - Tiền Giang','0333917493',3),
('Nguyễn Thị T','ntt@gmail.com','123','Xã Bình Đức - Huyện Châu Thành - Tiền Giang','0948455139',3),
('Nguyễn Thị U','ntu@gmail.com','123','Xã Bình Đức - Huyện Châu Thành - Tiền Giang','0948455139',3),
('Nguyễn Thị V','ntv@gmail.com','123','Xã Bình Đức - Huyện Châu Thành - Tiền Giang','0948455139',3),
('Nguyễn Thị W','ntw@gmail.com','123','Xã Bình Đức - Huyện Châu Thành - Tiền Giang','0948455139',3),
('Nguyễn Thị X','ntx@gmail.com','123','Phường 5 - TP.Mỹ Tho - Tiền Giang','0971438134',3),
('Nguyễn Thị Y','nty@gmail.com','123','Xã Trung An - TP.Mỹ Tho - Tiền Giang','0565142401',3),
('Nguyễn Thị Z','ntz@gmail.com','123','Phường 9 - TP.Mỹ Tho - Tiền Giang','0121945176',3); 

insert into du_an (ten_du_an, mo_ta, ngay_bat_dau, ngay_ket_thuc, id_leader ) values
('Dự án CRM','Xây dựng hệ thống quản lý nhân viên công ty','03/31/2022','09/30/2022',2),
('Dự án Cineflix','Xây dựng hệ thống quản lý phim','03/31/2022','09/30/2022',3),
('Dự án Elearning','Xây dựng hệ thống hỗ trợ học lập trình OOP','03/31/2022','09/30/2022',2);

insert into cong_viec (ten_cv, ngay_bat_dau, ngay_ket_thuc, id_du_an, id_user_thuc_hien, id_trang_thai_cv) values
('Công việc 1','03/31/2022','09/30/2022', 1, 5, 1),
('Công việc 2','03/31/2022','09/30/2022', 1, 5, 1),
('Công việc 3','03/31/2022','09/30/2022', 1, 7, 2),
('Công việc 4','03/31/2022','09/30/2022', 1, 7, 2),
('Công việc 5','03/31/2022','09/30/2022', 1, 9, 3),
('Công việc 6','03/31/2022','09/30/2022', 1, 11, 3),
('Công việc 1','03/31/2022','09/30/2022', 2, 6, 2),
('Công việc 2','03/31/2022','09/30/2022', 2, 6, 2),
('Công việc 3','03/31/2022','09/30/2022', 2, 6, 2),
('Công việc 4','03/31/2022','09/30/2022', 2, 8, 2),
('Công việc 5','03/31/2022','09/30/2022', 2, 8, 2),
('Công việc 6','03/31/2022','09/30/2022', 2, 10, 3),
('Công việc 1','03/31/2022','09/30/2022', 3, 6, 1),
('Công việc 2','03/31/2022','09/30/2022', 3, 7, 3),
('Công việc 3','03/31/2022','09/30/2022', 3, 8, 3),
('Công việc 4','03/31/2022','09/30/2022', 3, 9, 2),
('Công việc 5','03/31/2022','09/30/2022', 3, 6, 2),
('Công việc 6','03/31/2022','09/30/2022', 3, 5, 1);


