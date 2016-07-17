package snapchat;
import java.util.*;

/*
*http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=192719&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3089%5D%5Bvalue%5D%5B2%5D%3D2%26searchoption%5B3089%5D%5Btype%5D%3Dcheckbox%26searchoption%5B3046%5D%5Bvalue%5D%3D21%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311
*/

public class EmployeeLCA {
	public class Employee{
		int employee_id;
		Employee[] direct_reports;
		public Employee(int employee_id, Employee[] direct_reports) {
			this.employee_id = employee_id;
			this.direct_reports = direct_reports;
		}
		public int get_employee_id() {
			return this.employee_id;
		}

		public Employee[] get_reports() {
			return this.direct_reports;
		}
	}

	public class Company {
		Employee ceo;
		public Company() {
			this.ceo = ceo;
		}

		public Employee find_least_important_common_boss(Employee e1_id, Employee e2_id) {
			return find_least_important_common_boss(ceo,e1_id, e2_id);
		}

		private Employee find_least_important_common_boss(Employee root, Employee e1_id, Employee e2_id) {
			if (root==null) return null;
			if (root==e1_id || root==e2_id) return root;
			int count = 0;
			Employee boss=null;
			for (Employee employee: root.get_reports()) {
				Employee temp;
				if ((temp=find_least_important_common_boss(employee,e1_id, e2_id))!=null) {
					count++;
					boss = temp;
				}
			}

			return (count==2)?root: boss;
		}
	}
}