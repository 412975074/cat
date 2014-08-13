package com.dianping.cat.report.page.alert;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.unidal.web.mvc.ActionContext;
import org.unidal.web.mvc.ActionPayload;
import org.unidal.web.mvc.payload.annotation.FieldMeta;

import com.dianping.cat.helper.TimeUtil;
import com.dianping.cat.report.ReportPage;
import com.site.lookup.util.StringUtils;

public class Payload implements ActionPayload<ReportPage, Action> {
	private ReportPage m_page;

	@FieldMeta("channel")
	private String m_channel;

	@FieldMeta("title")
	private String m_title;

	@FieldMeta("content")
	private String m_content;

	@FieldMeta("group")
	private String m_group;

	@FieldMeta("domain")
	private String m_domain;

	@FieldMeta("level")
	private String m_level;

	@FieldMeta("metric")
	private String m_metric;

	@FieldMeta("startTime")
	private String m_startTime;

	@FieldMeta("endTime")
	private String m_endTime;

	@FieldMeta("type")
	private String m_type;

	@FieldMeta("op")
	private Action m_action;

	@FieldMeta("receivers")
	private String m_receivers;
	
	@FieldMeta("reportType")
	private String m_reportType = "";

	private DateFormat m_format = new SimpleDateFormat("yyyy-MM-dd HH:mm");

	@Override
	public Action getAction() {
		return m_action;
	}

	public String getChannel() {
		if (StringUtils.isEmpty(m_channel)) {
			return "";
		} else {
			return m_channel;
		}
	}

	public String getContent() {
		if (StringUtils.isEmpty(m_content)) {
			return "";
		} else {
			return m_content;
		}
	}

	public String getDomain() {
		if (StringUtils.isEmpty(m_domain)) {
			return null;
		} else {
			return m_domain;
		}
	}

	public Date getEndTime() {
		try {
			return m_format.parse(m_endTime);
		} catch (Exception e) {
			return new Date();
		}
	}

	public String getGroup() {
		if (StringUtils.isEmpty(m_group)) {
			return "default";
		} else {
			return m_group;
		}
	}

	public String getLevel() {
		if (StringUtils.isEmpty(m_level)) {
			return null;
		} else {
			return m_level;
		}
	}

	public String getMetric() {
		if (StringUtils.isEmpty(m_metric)) {
			return null;
		} else {
			return m_metric;
		}
	}

	@Override
	public ReportPage getPage() {
		return m_page;
	}

	public String getReceivers() {
		if (StringUtils.isEmpty(m_receivers)) {
			return "";
		} else {
			return m_receivers;
		}
	}

	public String getReportType() {
		return m_reportType;
	}

	public Date getStartTime() {
		try {
			return m_format.parse(m_startTime);
		} catch (Exception e) {
			return new Date(System.currentTimeMillis() - TimeUtil.ONE_HOUR);
		}
	}

	public String getTitle() {
		if (StringUtils.isEmpty(m_title)) {
			return "";
		} else {
			return m_title;
		}
	}

	public String getType() {
		if (StringUtils.isEmpty(m_type)) {
			return "call";
		} else {
			return m_type;
		}
	}

	public void setAction(String action) {
		m_action = Action.getByName(action, Action.VIEW);
	}

	public void setChannel(String channel) {
		m_channel = channel;
	}

	public void setContent(String content) {
		m_content = content;
	}

	public void setDomain(String domain) {
		m_domain = domain;
	}

	public void setEndTime(String endTime) {
		m_endTime = endTime;
	}

	public void setGroup(String group) {
		m_group = group;
	}

	public void setLevel(String level) {
		m_level = level;
	}

	public void setMetric(String metric) {
		m_metric = metric;
	}

	@Override
	public void setPage(String page) {
		m_page = ReportPage.getByName(page, ReportPage.ALERT);
	}

	public void setReceivers(String receivers) {
		m_receivers = receivers;
	}

	public void setReportType(String reportType) {
		m_reportType = "";
	}

	public void setStartTime(String startTime) {
		m_startTime = startTime;
	}

	public void setTitle(String title) {
		m_title = title;
	}

	public void setType(String type) {
		m_type = type;
	}

	@Override
	public void validate(ActionContext<?> ctx) {
		if (m_action == null) {
			m_action = Action.ALERT;
		}
	}
}
