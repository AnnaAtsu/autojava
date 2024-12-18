package model;

public record DataContact(String firstname, String middlename, String lastname, String photo) {

    public DataContact() {
        this("", "", "", "");
    }

    public DataContact withFirstName(String firstname) {
        return  new DataContact(firstname, this.middlename, this.lastname, this.photo);
    }


    public DataContact withMiddleName(String middlename) {
        return  new DataContact(this.firstname, middlename, this.lastname, this.photo);
    }

      public DataContact withLastname(String lastname) {
        return  new DataContact(this.firstname, this.middlename, lastname, this.photo);
    }
    public DataContact withPhoto(String photo) {
        return  new DataContact(this.firstname, this.middlename, this.lastname, photo);
    }



}