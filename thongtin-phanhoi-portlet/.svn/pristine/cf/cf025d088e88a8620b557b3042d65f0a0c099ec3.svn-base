package vn.dtt.ns.minhbach;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.AuthCache;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.ClientContext;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.BasicAuthCache;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.util.EntityUtils;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class TestLiferayJSON {
	private static Log _log = LogFactoryUtil.getLog(TestLiferayJSON.class);

	private static String URL = "119.17.253.82"; // hanoi : hanoi.dtt.vn , that :  119.17.253.82
	private static int PORT = 80; // hanoi : 8182 , that : 80
	private static String SCHEME = "http";
	private static String USERNAME = "test@liferay.com"; // hanoi :  test@liferay.com  , that :  test@liferay.com
	private static String PASSWORD = "dtt@2015"; // hanoi : test , that  : dtt@2015
	private static String API_ADD_ARTICLE = "/api/jsonws/journalarticle/add-article";
	private static String API_UPDATE_ARTICLE = "/api/jsonws/journalarticle/update-article";

	 public static void main(String[] args) throws Exception {
			Calendar cal = Calendar.getInstance();
			//cal.set(2015, 1, 18);

			// Format the month.
			String result = String.format("Month: %1$tB %1$tb %1$tm", cal);
			System.out.println(result);

			// Format the day.
			result = String.format("Day: %1$tA %1$ta %1$td", cal);
			System.out.println(result);

			// Format the year.
			result = String.format("Year: %1$ty-%1$tm", cal);
			System.out.println(result);
		 System.out.println(zeroPad(1, 5));
	 }
	
	public static String zeroPad(long number, int width) {
		   long wrapAt = (long)Math.pow(10, width);
		   return String.valueOf(number % wrapAt + wrapAt).substring(1);
		}

	public static ModelAddUpdateArticle addArticle(String titleIn,
			String contentIn) {
		ModelAddUpdateArticle result = null;
		HttpHost targetHost = new HttpHost(URL, PORT, SCHEME); 
		DefaultHttpClient httpclient = new DefaultHttpClient();
		httpclient.getCredentialsProvider().setCredentials(
				new AuthScope(targetHost.getHostName(), targetHost.getPort()),
				new UsernamePasswordCredentials(USERNAME, PASSWORD)); 

		// Create AuthCache instance
		AuthCache authCache = new BasicAuthCache();
		// Generate BASIC scheme object and add it to the local auth cache
		BasicScheme basicAuth = new BasicScheme();
		authCache.put(targetHost, basicAuth);

		// Add AuthCache to the execution context

		BasicHttpContext ctx = new BasicHttpContext();
		ctx.setAttribute(ClientContext.AUTH_CACHE, authCache);

		HttpPost post = new HttpPost(API_ADD_ARTICLE);
		Calendar yesterday = Calendar.getInstance();
		// yesterday.add(Calendar.DAY_OF_YEAR, -1);
		Calendar nextWeek = Calendar.getInstance();
		nextWeek.add(Calendar.WEEK_OF_YEAR, 1);

		String xmlContent = "<?xml version='1.0' encoding='UTF-8'?>"
				+ "<root default-locale=\"vi_VN\" available-locales=\"en_US,vi_VN\">"
				+ "<static-content language-id=\"en_US\">" + "<![CDATA["
				+ contentIn + "]]>" + "</static-content>"
				+ "<static-content language-id=\"vi_VN\">" + "<![CDATA["
				+ contentIn + "]]>" + "</static-content>" + "</root>";

		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("groupId", "40471")); // hanoi: 10181  that: 40471
		params.add(new BasicNameValuePair("folderId", "0"));
		params.add(new BasicNameValuePair("classNameId", "0"));
		params.add(new BasicNameValuePair("classPK", "0"));
		params.add(new BasicNameValuePair("articleId", "800"));
		params.add(new BasicNameValuePair("autoArticleId", "true"));
		params.add(new BasicNameValuePair("titleMap", "{\"vi_VN\":\" "+ titleIn + " \"}"));
		params.add(new BasicNameValuePair("descriptionMap","{\"vi_VN\":\"  \"}"));
		// params.add(new BasicNameValuePair("content",
		// "<?xml version=\"1.0\"?><root available-locales=\"vi_VN\" default-locale=\"vi_VN\">"
		// +
		// "<dynamic-element name=\"content\" type=\"text_area\" index-type=\"keyword\" index=\"0\">"
		// + "<dynamic-content language-id=\"vi_VN\">" +
		// "<![CDATA["+content+"]]></dynamic-content></dynamic-element></root>"));
		params.add(new BasicNameValuePair("content", xmlContent));
		params.add(new BasicNameValuePair("type", "general"));
		params.add(new BasicNameValuePair("ddmStructureKey", ""));
		params.add(new BasicNameValuePair("ddmTemplateKey", ""));
		params.add(new BasicNameValuePair("layoutUuid", ""));
		params.add(new BasicNameValuePair("displayDateMonth", ""+ (yesterday.get(Calendar.MONTH))));
		params.add(new BasicNameValuePair("displayDateDay", ""+ yesterday.get(Calendar.DAY_OF_MONTH)));
		params.add(new BasicNameValuePair("displayDateYear", ""+ yesterday.get(Calendar.YEAR)));
		params.add(new BasicNameValuePair("displayDateHour", ""+ yesterday.get(Calendar.HOUR_OF_DAY)));
		params.add(new BasicNameValuePair("displayDateMinute", ""+ yesterday.get(Calendar.MINUTE)));
		params.add(new BasicNameValuePair("expirationDateMonth", ""+ (1 + nextWeek.get(Calendar.MONTH))));
		params.add(new BasicNameValuePair("expirationDateDay", ""+ nextWeek.get(Calendar.DAY_OF_MONTH)));
		params.add(new BasicNameValuePair("expirationDateYear", ""+ nextWeek.get(Calendar.YEAR)));
		params.add(new BasicNameValuePair("expirationDateHour", ""+ nextWeek.get(Calendar.HOUR_OF_DAY)));
		params.add(new BasicNameValuePair("expirationDateMinute", ""+ nextWeek.get(Calendar.MINUTE)));
		params.add(new BasicNameValuePair("neverExpire", "true"));
		params.add(new BasicNameValuePair("reviewDateMonth", ""+ (1 + nextWeek.get(Calendar.MONTH))));
		params.add(new BasicNameValuePair("reviewDateDay", ""+ nextWeek.get(Calendar.DAY_OF_MONTH)));
		params.add(new BasicNameValuePair("reviewDateYear", ""+ nextWeek.get(Calendar.YEAR)));
		params.add(new BasicNameValuePair("reviewDateHour", ""+ nextWeek.get(Calendar.HOUR_OF_DAY)));
		params.add(new BasicNameValuePair("reviewDateMinute", ""+ nextWeek.get(Calendar.MINUTE)));
		params.add(new BasicNameValuePair("neverReview", "true"));
		params.add(new BasicNameValuePair("indexable", "true"));
		params.add(new BasicNameValuePair("articleURL", "articleURL"));
		params.add(new BasicNameValuePair("serviceContext", "{}"));
		params.add(new BasicNameValuePair("serviceContext.scopeGroupId","10181"));
		params.add(new BasicNameValuePair("serviceContext.assetCategoryIds","42410")); // hanoi: 28710 that: 42410
		try {
			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(params, "UTF-8");
			post.setEntity(entity);
			HttpResponse resp = httpclient.execute(targetHost, post, ctx);
			String str = "";

			_log.info("--addArticle--" + resp.getStatusLine());
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			resp.getEntity().writeTo(baos);
			str = baos.toString();

			result = new ModelAddUpdateArticle();
			JSONObject json_data = JSONFactoryUtil.createJSONObject(str);

			/* can lay them gi thi lay, 14-06-2016 */
			String articleId = json_data.getString("articleId");
			// String classNameId = json_data.getString("classNameId");
			// String classPK = json_data.getString("classPK");
			// String companyId = json_data.getString("companyId");
			// String content = json_data.getString("content");
			// String createDate = json_data.getString("createDate");
			// String description = json_data.getString("description");
			// String descriptionCurrentValue =
			// json_data.getString("descriptionCurrentValue");
			// String displayDate = json_data.getString("displayDate");
			// String expirationDate =
			// json_data.getString("expirationDate");
			// String folderId = json_data.getString("folderId");
			String groupId = json_data.getString("groupId");
			// String id = json_data.getString("id");
			// boolean indexable = json_data.getBoolean("indexable");
			// String layoutUuid = json_data.getString("layoutUuid");
			// String modifiedDate = json_data.getString("modifiedDate");
			// String resourcePrimKey =
			// json_data.getString("resourcePrimKey");
			// String reviewDate = json_data.getString("reviewDate");
			// boolean smallImage = json_data.getBoolean("smallImage");
			// String smallImageId = json_data.getString("smallImageId");
			// String smallImageURL = json_data.getString("smallImageURL");
			// String status = json_data.getString("status");
			// String statusByUserId =
			// json_data.getString("statusByUserId");
			// String statusByUserName =
			// json_data.getString("statusByUserName");
			// String statusDate = json_data.getString("statusDate");
			// String structureId = json_data.getString("structureId");
			// String templateId = json_data.getString("templateId");
			// String title = json_data.getString("title");
			// String titleCurrentValue =
			// json_data.getString("titleCurrentValue");
			// String treePath = json_data.getString("treePath");
			// String type = json_data.getString("type");
			// String urlTitle = json_data.getString("urlTitle");
			String userId = json_data.getString("userId");
			// String userName = json_data.getString("userName");
			// String uuid = json_data.getString("uuid");
			String version = json_data.getString("version");

			result.setArticleId(articleId);
			result.setGroupId(groupId);
			result.setUserId(userId);
			result.setVersion(version);
			_log.info("out--articleId-" + result.getArticleId());
			EntityUtils.consume(entity);
		} catch (Exception e) {
			result = null;
			e.printStackTrace();
		} finally {
			httpclient.getConnectionManager().shutdown();
		}

		return result;
	}

	public static ModelAddUpdateArticle updateArticle(String articleIdIn, String groupIdIn,  String userIdIn, String versionIn,
			String titleIn, String contentIn) {

		ModelAddUpdateArticle result = null;
		HttpHost targetHost = new HttpHost(URL, PORT, SCHEME);
		DefaultHttpClient httpclient = new DefaultHttpClient();
		httpclient.getCredentialsProvider().setCredentials(
				new AuthScope(targetHost.getHostName(), targetHost.getPort()),
				new UsernamePasswordCredentials(USERNAME, PASSWORD));

		// Create AuthCache instance
		AuthCache authCache = new BasicAuthCache();
		// Generate BASIC scheme object and add it to the local auth cache
		BasicScheme basicAuth = new BasicScheme();
		authCache.put(targetHost, basicAuth);

		// Add AuthCache to the execution context

		BasicHttpContext ctx = new BasicHttpContext();
		ctx.setAttribute(ClientContext.AUTH_CACHE, authCache);

		HttpPost post = new HttpPost(API_UPDATE_ARTICLE);
		Calendar nextWeek = Calendar.getInstance();
		nextWeek.add(Calendar.WEEK_OF_YEAR, 1);

		String xmlContent = "<?xml version='1.0' encoding='UTF-8'?>"
				+ "<root default-locale=\"vi_VN\" available-locales=\"en_US,vi_VN\">"
				+ "<static-content language-id=\"en_US\">" + "<![CDATA["
				+ contentIn + "]]>" + "</static-content>"
				+ "<static-content language-id=\"vi_VN\">" + "<![CDATA["
				+ contentIn + "]]>" + "</static-content>" + "</root>";

		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("articleId", articleIdIn));
		params.add(new BasicNameValuePair("groupId", groupIdIn)); // hanoi:  10181  that:  40471
		params.add(new BasicNameValuePair("userId", userIdIn));
		params.add(new BasicNameValuePair("version", versionIn));

		params.add(new BasicNameValuePair("folderId", "0"));
		params.add(new BasicNameValuePair("titleMap", "{\"vi_VN\":\" " + titleIn + " \"}"));
		params.add(new BasicNameValuePair("descriptionMap", "{\"vi_VN\":\" " + titleIn + " \"}"));
		params.add(new BasicNameValuePair("content", xmlContent));
		params.add(new BasicNameValuePair("layoutUuid", ""));

		params.add(new BasicNameValuePair("serviceContext", "{}"));
		params.add(new BasicNameValuePair("serviceContext.scopeGroupId", "10181"));
		params.add(new BasicNameValuePair("serviceContext.assetCategoryIds", "42410")); // hanoi: 28710 that: 42410
		try {
			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(params, "UTF-8");
			post.setEntity(entity);
			HttpResponse resp = httpclient.execute(targetHost, post, ctx);

			String str = "";

			_log.info("--updateArticle--" + resp.getStatusLine());
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			resp.getEntity().writeTo(baos);
			str = baos.toString();
			result = new ModelAddUpdateArticle();
			JSONObject json_data = JSONFactoryUtil.createJSONObject(str);

			/* can lay them gi thi lay, 14-06-2016 */
			String articleId = json_data.getString("articleId");
			// String classNameId = json_data.getString("classNameId");
			// String classPK = json_data.getString("classPK");
			// String companyId = json_data.getString("companyId");
			// String content = json_data.getString("content");
			// String createDate = json_data.getString("createDate");
			// String description = json_data.getString("description");
			// String descriptionCurrentValue =
			// json_data.getString("descriptionCurrentValue");
			// String displayDate = json_data.getString("displayDate");
			// String expirationDate = json_data.getString("expirationDate");
			// String folderId = json_data.getString("folderId");
			String groupId = json_data.getString("groupId");
			// String id = json_data.getString("id");
			// boolean indexable = json_data.getBoolean("indexable");
			// String layoutUuid = json_data.getString("layoutUuid");
			// String modifiedDate = json_data.getString("modifiedDate");
			// String resourcePrimKey = json_data.getString("resourcePrimKey");
			// String reviewDate = json_data.getString("reviewDate");
			// boolean smallImage = json_data.getBoolean("smallImage");
			// String smallImageId = json_data.getString("smallImageId");
			// String smallImageURL = json_data.getString("smallImageURL");
			// String status = json_data.getString("status");
			// String statusByUserId = json_data.getString("statusByUserId");
			// String statusByUserName =
			// json_data.getString("statusByUserName");
			// String statusDate = json_data.getString("statusDate");
			// String structureId = json_data.getString("structureId");
			// String templateId = json_data.getString("templateId");
			// String title = json_data.getString("title");
			// String titleCurrentValue =
			// json_data.getString("titleCurrentValue");
			// String treePath = json_data.getString("treePath");
			// String type = json_data.getString("type");
			// String urlTitle = json_data.getString("urlTitle");
			String userId = json_data.getString("userId");
			// String userName = json_data.getString("userName");
			// String uuid = json_data.getString("uuid");
			String version = json_data.getString("version");

			result.setArticleId(articleId);
			result.setGroupId(groupId);
			result.setUserId(userId);
			result.setVersion(version);

			EntityUtils.consume(entity);

		} catch (Exception e) {
			result = null;
			e.printStackTrace();
		} finally {
			httpclient.getConnectionManager().shutdown();
		}

		return result;
	}
}