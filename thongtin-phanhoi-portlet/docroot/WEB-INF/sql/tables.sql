create table thongtinphanhoi_TopicDetails (
	id LONG not null primary key,
	sodienthoai VARCHAR(75) null,
	thoigiangoi DATE null,
	tongdai INTEGER,
	matinh VARCHAR(75) null,
	mahuyen VARCHAR(75) null,
	maxa VARCHAR(75) null,
	matramcapnuoc VARCHAR(75) null,
	mathongtinphananh VARCHAR(75) null,
	noidungkhac_nuoc VARCHAR(75) null,
	noidungkhac_vesinh VARCHAR(75) null,
	yeucau_giaitrinh_id LONG
);

create table thongtinphanhoi_TopicPhanHoi (
	code VARCHAR(75) not null primary key,
	matinh VARCHAR(75) null,
	mahuyen VARCHAR(75) null,
	maxa VARCHAR(75) null,
	name VARCHAR(75) null
);