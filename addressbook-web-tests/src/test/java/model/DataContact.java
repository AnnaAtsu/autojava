package model;

public record DataContact(String firstname, String middlename, String lastname) {

    public DataContact() {
        this("", "", "");
    }

    public DataContact withFirstName(String firstname) {
        return  new DataContact(firstname, this.middlename, this.lastname);
    }


    public DataContact withMiddleName(String middlename) {
        return  new DataContact(this.firstname, middlename, this.lastname);
    }

      public DataContact withLastname(String lastname) {
        return  new DataContact(this.firstname, this.middlename, lastname);
    }
}