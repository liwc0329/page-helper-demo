package com.g7go.pagehelperdemo.common.config;


import com.p6spy.engine.spy.appender.MessageFormattingStrategy;
import org.springframework.util.StringUtils;

/**
 * P6spy SQL 日志格式化
 *
 * @author lwc
 */
public class P6spyLogFormat implements MessageFormattingStrategy {

    @Override
    public String formatMessage(final int connectionId, final String now, final long elapsed, final String category, final String prepared, final String sql, final String url) {
        return !StringUtils.isEmpty(sql) ? "Execute SQL：" + sql.replaceAll("[\\s]+", " ") : null;
    }
}