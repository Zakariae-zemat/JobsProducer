package jobsProducerPackage;




public class Job {
    private String id;
    private String title;
    private String description;
    private String location;
    private String company;
    private Number salary_min;
    private Number salary_max;
    private String created;
    private String category;

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Number getSalary_min() {
        return salary_min;
    }

    public void setSalary_min(Number salary_min) {
        this.salary_min = salary_min;
    }


    public Number getSalary_max() {
        return salary_max;
    }

    public void setSalary_max(Number salary_max) {
        this.salary_max = salary_max;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    

    @Override
    public String toString() {
        return "Job{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", location='" + location + '\'' +
                ", company='" + company + '\'' +
                ", salary_min='" + salary_min + '\'' +
                ", salary_max='" + salary_max + '\'' +
                ", created='" + created + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
