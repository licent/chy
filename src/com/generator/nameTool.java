package com.generator;

public class nameTool {
	public static void main(String[] args) {

		/**
		 * SELECT table_name FROM information_schema. TABLES WHERE table_schema = 'chy';
		 */
		String[] ss = { "admin_article", "admin_auth_group", "admin_auth_group_access", "admin_auth_rule",
				"admin_users", "abnormal_order", "admin", "admin_role", "appliction_record", "auto_point",
				"auto_pointask", "award_logs", "bouns_logs", "budan", "cart", "factory", "flow_enter", "import", "item",
				"item_cats", "item_change", "item_collect", "item_sku", "item_tag", "order", "order_item", "orders",
				"permission", "role", "role_permission", "search_history", "shopowner", "store", "title_history",
				"user", "user_address", "user_fct", "visitors_tag", "withdrawal", "tab" };
		for (int i = 0; i < ss.length; i++) {
			// System.out.println(ss[i]);
			String s = "";
			int flag = -1;
			for (int e = 0; e < ss[i].length(); e++) {
				String c = ss[i].substring(e, e + 1);

				if ("_".equals(c)) {
					flag = e + 1;
					continue;
				}

				if (e == 0) {
					s += c.toUpperCase();
					continue;
				}

				if (flag != e) {
					s += c;
				} else {
					s += c.toUpperCase();
				}

			}
			System.out.println(s+"Pojo");
			// System.out.println("---------------------------------------");
		}
	}
}
