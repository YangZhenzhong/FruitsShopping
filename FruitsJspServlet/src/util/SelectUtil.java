package util;
/**
 * 默认按库存降序
 * @author yzz
 *
 */
public class SelectUtil {
	/**
	 * 类别id
	 */
	private int s_id;
	/**
	 * 按此列排序
	 */
	private String colName="f_kucun";
	/**
	 * 升降序
	 */
	private RuleEnum rule=RuleEnum.DESC;
	/**
	 * 搜索关键字
	 */
	private String key="";
	public int getS_id() {
		return s_id;
	}
	public void setS_id(int s_id) {
		this.s_id = s_id;
	}
	public String getColName() {
		return colName;
	}
	public void setColName(String colName) {
		this.colName = colName;
	}

	public RuleEnum getRule() {
		return rule;
	}
	public void setRule(RuleEnum rule) {
		this.rule = rule;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	
	
	
}
