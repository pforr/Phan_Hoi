package vn.dtt.ns.thongtinphanhoi.util;

public class ThongTinPhanHoiConstants {
	public interface TrangThaiYcgt{
		public static final int DA_TAO_YCGT = 1;
		public static final int CHUA_TAO_YCGT = 0;
	}
	
	public interface TrangThaiGiaiTrinh{
		public static final int DA_TAO_YCGT = 1;
		public static final int DANG_XU_LY = 2;
		public static final int DA_DUOC_GIAI_TRINH = 3;
		public static final int HUY = 4;
	}
	
	public interface ActionMode{
		public static final int HUY_YCGT = 0;
		public static final int DONG_YCGT = 1;		
		public static final int LUU = 11;
		public static final int USER_TINH_GT = 12;
		public static final int GUI_DUYET = 21;
		public static final int GUI_GT = 31;
		public static final int YEUCAU_GIAITRINHLAI = 32;	
	}
	
	public interface Transfer2MinhBach{
		public static final int DA_CHUYENSAN_MINHBACH = 1;
		public static final int CHUA_CHUYENSAN_MINHBACH = 0;
	}
	public interface CoTaiKhoanGiaTrinh{
		public static final int CO = 1;
		public static final int KHONG = 0;
	}
}
