package com.wicket.algorithm.ac;

import lombok.AllArgsConstructor;
import lombok.ToString;

/**
 * @Copyright: com.wicket
 * @ProjectName: study
 * @Package: com.wicket.algorithm.ac
 * @ClassName: ParseResult
 * @Description: 匹配文本结果
 * @Author: CHS
 * @Date: 2023/6/19 14:01
 */
@ToString
@AllArgsConstructor
public class ParseResult {
    int startIndex;
    int endIndex;
    String key;
}
