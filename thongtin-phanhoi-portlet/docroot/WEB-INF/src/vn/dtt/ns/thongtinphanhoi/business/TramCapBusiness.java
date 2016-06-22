package vn.dtt.ns.thongtinphanhoi.business;

import java.util.ArrayList;
import java.util.List;

import vn.dtt.cmon.user.dao.model.UserMapping;
import vn.dtt.ns.thongtinphanhoi.business.UserMappingBusiness;
import vn.dtt.ns.thongtinphanhoi.business.TramCapBusiness;
import vn.dtt.sol.ns.tramcap.dao.model.TramCapNuoc;
import vn.dtt.sol.ns.tramcap.dao.service.TramCapNuocLocalServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;

public class TramCapBusiness {

	// function get id for import file excel
		public static List<TramCapNuoc> getByTenTram(String tenTram) {
			List<TramCapNuoc> ls = new ArrayList<TramCapNuoc>();

			try {

				ls = TramCapNuocLocalServiceUtil.getByTenTram(tenTram.trim());

			} catch (Exception e) {
				_log.error(e);
			}

			return ls;
		}

		public static List<TramCapNuoc> getByTinh(String maTinh) {
			List<TramCapNuoc> ls = new ArrayList<TramCapNuoc>();

			try {

				ls = TramCapNuocLocalServiceUtil.getByTinh(maTinh);

			} catch (Exception e) {
				_log.error(e);
			}

			return ls;
		}

		/**
		 * @param user
		 * @param maTinh
		 * @return
		 */
		public static List<TramCapNuoc> getByTinh(User user, String maTinh) {
			List<TramCapNuoc> ls = new ArrayList<TramCapNuoc>();

			UserMapping um = UserMappingBusiness.getUserMapping(user);

			int level = 0;

			if (Validator.isNotNull(um)) {
				level = um.getUserType();
			}

			try {
				if (level == 4) {
					TramCapNuoc tramCap = TramCapBusiness.getTramCap(Long
							.parseLong(um.getOrgCode2()));
					
					if (Validator.isNotNull(tramCap)) {
						ls.add(tramCap);
					}
				} else {
					ls = TramCapNuocLocalServiceUtil.getByTinh(maTinh);
				}
			} catch (Exception e) {
				_log.error(e);
			}

			return ls;
		}

		// TODO: bo xung logic cho phan nay
		public static int getSoDauNoi(long tramCapId) {
			int dauNoi = 0;

			return dauNoi;
		}

		// TODO: bo xung logic cho phan nay
		public static int getSoNguoiCapNuoc(long tramCapId) {
			int soNguoiCap = 0;

			return soNguoiCap;
		}

		/**
		 * @param tramCapId
		 * @return
		 */
		public static TramCapNuoc getTramCap(long tramCapId) {
			TramCapNuoc tramCap = null;

			try {
				tramCap = TramCapNuocLocalServiceUtil.fetchTramCapNuoc(tramCapId);
			} catch (Exception e) {
				_log.error(e);
			}

			return tramCap;
		}

		/**
		 * @param maTinh
		 * @param start
		 * @param end
		 * @return
		 */
		public static List<TramCapNuoc> findTramCap(String maTinh, int start,
				int end) {
			List<TramCapNuoc> list = new ArrayList<TramCapNuoc>();

			try {
				list = TramCapNuocLocalServiceUtil.findByTinh(maTinh, start, end);
			} catch (Exception e) {
				_log.error(e);
			}

			return list;
		}

		/**
		 * @param maTinh
		 * @return
		 */
		public static int countTramCap(String maTinh) {
			int count = 0;

			try {
				count = TramCapNuocLocalServiceUtil.countTramCapByTinh(maTinh);
			} catch (Exception e) {
				_log.error(e);
			}

			return count;
		}

		/**
		 * @param start
		 * @param end
		 * @return
		 */
		public static List<TramCapNuoc> findTramCap(int start, int end) {
			List<TramCapNuoc> list = new ArrayList<TramCapNuoc>();

			try {
				list = TramCapNuocLocalServiceUtil.getTramCap(start, end);
			} catch (Exception e) {
				_log.error(e);
			}

			return list;
		}

		/**
		 * @param user
		 * @param maTinh
		 * @param keyword
		 * @param start
		 * @param end
		 * @return
		 */
		public static List<TramCapNuoc> findTramCap(User user, String maTinh,
				String keyword, int start, int end) {
			List<TramCapNuoc> list = new ArrayList<TramCapNuoc>();

			UserMapping userMapping = UserMappingBusiness.getUserMapping(user);

			int level = 0;

			if (Validator.isNotNull(userMapping)) {
				level = userMapping.getUserType();
			}

			try {
				if (level == 0 || level == 1) {
					if (Validator.isNull(maTinh)) {
						list = TramCapNuocLocalServiceUtil.getTramCap(start, end);
					} else {
						list = TramCapNuocLocalServiceUtil.findByTinh(maTinh,
								start, end);
					}
				} else if (level == 2) {
					list = TramCapNuocLocalServiceUtil.findByTinh(maTinh, start,
							end);
				} else if (level == 4) {
					TramCapNuoc tramCap = TramCapNuocLocalServiceUtil
							.getTramCapNuoc(Long.parseLong(userMapping
									.getOrgCode2()));
					list.add(tramCap);
				}
			} catch (Exception e) {
				_log.error(e);
			}

			return list;
		}

		public static int countTramCap(User user, String maTinh, String keyword) {

			int count = 0;

			UserMapping userMapping = UserMappingBusiness.getUserMapping(user);

			int level = 0;

			if (Validator.isNotNull(userMapping)) {
				level = userMapping.getUserType();
			}

			try {
				if (level == 0 || level == 1) {
					if (Validator.isNull(maTinh)) {
						count = TramCapNuocLocalServiceUtil.countAllTramCap();
					} else {
						count = TramCapNuocLocalServiceUtil
								.countTramCapByTinh(maTinh);
					}
				} else if (level == 2) {
					count = TramCapNuocLocalServiceUtil.countTramCapByTinh(maTinh);
				} else if (level == 4) {
					count = 1;
				}

			} catch (Exception e) {
				_log.error(e);
			}

			return count;
		}

		/**
		 * @return
		 */
		public static int countTramCap() {
			int count = 0;

			try {
				count = TramCapNuocLocalServiceUtil.countAllTramCap();
			} catch (Exception e) {
				_log.error(e);
			}

			return count;
		}

		public static List<TramCapNuoc> getTramCapNuocByDanhGiaBenVung(
				String maTinh, String namBaoCao, String danhGiaBenVung) {
			List<TramCapNuoc> lst = new ArrayList<TramCapNuoc>();

			try {
				lst = TramCapNuocLocalServiceUtil.getTramCapNuocByDanhGiaBenVung(
						maTinh, namBaoCao, danhGiaBenVung);
			} catch (Exception e) {
				_log.error(e);
			}

			return lst;
		}

		public static List<TramCapNuoc> getTramCapNuocByTinhDauNoiNuoc(String maTinh, String namBaoCao, String trangThai) {
			List<TramCapNuoc> lst = new ArrayList<TramCapNuoc>();

			try {
				lst = TramCapNuocLocalServiceUtil.getTramCapNuocByTinhDauNoiNuoc(maTinh, namBaoCao,trangThai);
			} catch (Exception e) {
				_log.error(e);
			}

			return lst;
		}

		
		public static List<TramCapNuoc> getTramCapNuocJoinDanhGiaBenVung(String maTinh, String nam) {
			List<TramCapNuoc> lst = new ArrayList<TramCapNuoc>();
			try{
				lst = TramCapNuocLocalServiceUtil.getTramCapNuocJoinDanhGiaBenVung(maTinh,nam);
			}catch (Exception e) {
				_log.error(e);
			}

			return lst;
		}
		
		public static List<TramCapNuoc> getTramCapNuocByThoiGianThuc(String maTinh, String namBaoCao, String danhgiakiemdem, String daketthucdieutra) {
			List<TramCapNuoc> lst = new ArrayList<TramCapNuoc>();
			try{
				lst = TramCapNuocLocalServiceUtil.getTramCapNuocByThoiGianThuc(maTinh,namBaoCao,danhgiakiemdem,daketthucdieutra);
			}catch (Exception e) {
				_log.error(e);
			}

			return lst;
		}
		
		public static int countDauNoiTramCapThoiGianThuc(String maTinh, String namBaoCao, String danhgiakiemdem, String tramCapNuocId, String daketthucdieutra) {
			int count = 0;

			try {
				count = TramCapNuocLocalServiceUtil.countDauNoiTramCapThoiGianThuc(maTinh,namBaoCao,danhgiakiemdem,tramCapNuocId,daketthucdieutra);
			} catch (Exception e) {
				_log.error(e);
			}

			return count;
		}

		public static TramCapNuoc getTramCapNuocByMaTinhAndDNNID(String maTinh, String dauNoiNuocID) {
			TramCapNuoc tramCap = null;

			try {
				tramCap = TramCapNuocLocalServiceUtil.getTramCapNuocByMaTinhAndDNNID(maTinh,dauNoiNuocID);
			} catch (Exception e) {
				_log.error(e);
			}

			return tramCap;
		}
		
		public static List<TramCapNuoc> getTramCapJoinDanhGiaBenVungGroupByMaTinhTW(String maTinh,  String nam, String ketquadanhgia) {
			List<TramCapNuoc> lst = new ArrayList<TramCapNuoc>();
			try{
				lst = TramCapNuocLocalServiceUtil.getTramCapJoinDanhGiaBenVungGroupByMaTinhTW( maTinh, nam,  ketquadanhgia);
			}catch (Exception e) {
				_log.error(e);
			}
			return lst;
		}
		public static List<TramCapNuoc> getTramCapJoinDanhGiaBenVungGroupByMaHuyenXaTW( String nam, String maTinh ,String ketquadanhgia) {
			List<TramCapNuoc> lst = new ArrayList<TramCapNuoc>();
			try{
				lst = TramCapNuocLocalServiceUtil.getTramCapJoinDanhGiaBenVungGroupByMaHuyenXaTW(  nam,  maTinh , ketquadanhgia);
			}catch (Exception e) {
				_log.error(e);
			}
			return lst;
		}
		public static List<TramCapNuoc> getTramCapNuocJoinDanhGiaBenVungBaoCaoHopNhat(String maTinh, int nam, int namToiThieu) {
			List<TramCapNuoc> lst = new ArrayList<TramCapNuoc>();
			try{
				lst = TramCapNuocLocalServiceUtil.getTramCapNuocJoinDanhGiaBenVungBaoCaoHopNhat(maTinh,nam,namToiThieu);
			}catch (Exception e) {
				_log.error(e);
			}
			return lst;
		}
		
		public static int sumDauNoiTramCapBaoCaoHopNhat(String maTinh, int nam, int namToiThieu,String tramCapId, int isThietKe, int isThucTe) {
			int count = 0;

			try {
				count = TramCapNuocLocalServiceUtil.sumDauNoiTramCapBaoCaoHopNhat( maTinh,  nam,  namToiThieu, tramCapId,  isThietKe,  isThucTe) ;
			} catch (Exception e) {
				_log.error(e);
			}

			return count;
		}
		public static List<TramCapNuoc> getTramCapJoinKeHoachNuocBaoCaoThongKeDNN(String nam, String maTinh,String maHuyen,String maXa, String maTram) {
			List<TramCapNuoc> lst = new ArrayList<TramCapNuoc>();
			try{
				lst = TramCapNuocLocalServiceUtil.getTramCapJoinKeHoachNuocBaoCaoThongKeDNN( nam,  maTinh, maHuyen, maXa,  maTram);
			}catch (Exception e) {
				_log.error(e);
			}
			return lst;
		}
		private static Log _log = LogFactoryUtil.getLog(TramCapBusiness.class);
}
