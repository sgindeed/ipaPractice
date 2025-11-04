import java.util.*;
class Main{
    public static void main(String[] args){
        Scanner se = new Scanner(System.in);
        int n = se.nextInt();
        List<Project> projectList = new ArrayList<>();
        List<Employee> employeeList = new ArrayList<>();

        for(int i=0; i<n; i++){
            int proid = se.nextInt();
            se.nextLine();
            String proname = se.nextLine();
            String prostatus = se.nextLine();

            Project project = new Project(proid, proname, prostatus);

            int eid = se.nextInt();
            se.nextLine();
            String ename = se.nextLine();
            String edept = se.nextLine();
            double salary = se.nextDouble();
            se.nextLine();
            Employee employee = new Employee(eid, ename, edept, salary, project);

            projectList.add(project);
            employeeList.add(employee);
        }

        String findstatus = se.nextLine();
        String hikedept = se.nextLine();
        System.out.println("Reading salary now...");
        double percentagehike = se.nextDouble();
        System.out.println("Salary read successfully: " + percentagehike);
        se.nextLine();


        List<Employee> res1 = findEmployeesByProjectStatus(employeeList, findstatus);
        List<Employee> res2 = calculateSalaryHikeByDepartment(employeeList, hikedept, percentagehike);

        if(!res1.isEmpty()){
            for(int i=0; i<res1.size(); i++){
                System.out.println("Employee: "+res1.get(i).getEname()+", Department: "+res1.get(i).getEdept());
            }
        }
        else
            System.out.println("No employees found for project status: "+ findstatus);

        if(res2.isEmpty()){
            System.out.println("No employees found in the " +hikedept+"department.");
        }
        else{
            for(int i=0; i<n; i++){
                System.out.println("Employee: " + employeeList.get(i).getEname() + ", Updated Salary: " + employeeList.get(i).getSalary());
            }
        }
    }

    public static List<Employee> findEmployeesByProjectStatus(List<Employee> employeeList, String status){
        List<Employee> stalist = new ArrayList<>();
        for(int i=0; i<employeeList.size(); i++){
            if(employeeList.get(i).getProject().getProstatus().equalsIgnoreCase(status))
                stalist.add(employeeList.get(i));
        }
        return stalist;
    }

    public static List<Employee> calculateSalaryHikeByDepartment(List<Employee> employeeList, String hikedept, double percentagehike){
        List<Employee> hikelist = new ArrayList<>();
        for(int i=0; i<employeeList.size(); i++){
            if(employeeList.get(i).getEdept().equalsIgnoreCase(hikedept)){
                double newsalary = employeeList.get(i).getSalary() + (employeeList.get(i).getSalary() * percentagehike) / 100;
                employeeList.get(i).setSalary(newsalary);
                hikelist.add(employeeList.get(i));
            }
        }
        return hikelist;
    }
}

class Project{
    private int proid;
    private String proname;
    private String prostatus;

    public Project(int proid, String proname, String prostatus){
        this.proid = proid;
        this.proname = proname;
        this.prostatus = prostatus;
    }
    public int getProid() {
        return proid;
    }

    public void setProid(int proid) {
        this.proid = proid;
    }

    public String getProname() {
        return proname;
    }

    public void setProname(String proname) {
        this.proname = proname;
    }

    public String getProstatus() {
        return prostatus;
    }

    public void setProstatus(String prostatus) {
        this.prostatus = prostatus;
    }
}

class Employee{
    private int eid;
    private String ename;
    private String edept;
    private double salary;
    private Project project;

    public Employee(int eid, String ename, String edept, double salary, Project project){
        this.eid = eid;
        this.ename = ename;
        this.edept = edept;
        this.salary = salary;
        this.project = project;
    }

    public int getEid() {
    return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getEdept() {
        return edept;
    }

    public void setEdept(String edept) {
        this.edept = edept;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
