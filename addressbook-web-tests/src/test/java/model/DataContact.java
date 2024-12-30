package model;

public record DataContact(String id,
                          String firstname,
                          String middlename,
                          String lastname,
                          String photo,
                          String home,
                          String mobile,
                          String work,
                          String secondary,
                          String email,
                          String email2,
                          String email3,
                          String address,
                          String address2) {

    public DataContact() {
        this("", "", "", "", "", "", "", "", "", "", "", "", "", "");
    }

    public DataContact withFirstName(String firstname) {
        return new DataContact(this.id, firstname, this.middlename, this.lastname, this.photo, this.home, this.mobile, this.work, this.secondary, this.email, this.email2, this.email3, "", "");
    }


    public DataContact withMiddleName(String middlename) {
        return new DataContact(this.id, this.firstname, middlename, this.lastname, this.photo, this.home, this.mobile, this.work, this.secondary, "", "", "", "", "");
    }

    public DataContact withLastname(String lastname) {
        return new DataContact(this.id, this.firstname, this.middlename, lastname, this.photo, this.home, this.mobile, this.work, this.secondary, "", "", "", "", "");
    }

    public DataContact withPhoto(String photo) {
        return new DataContact(this.id, this.firstname, this.middlename, this.lastname, photo, this.home, this.mobile, this.work, this.secondary, "", "", "", "", "");
    }

    public DataContact withId(String id) {
        return new DataContact(id, this.firstname, this.middlename, this.lastname, this.photo, this.home, this.mobile, this.work, this.secondary, this.email, this.email2, this.email3, this.address, this.address2);
    }

    public DataContact withHome(String home) {
        return new DataContact(id, this.firstname, this.middlename, this.lastname, this.photo, home, this.mobile, this.work, this.secondary, this.email, this.email2, this.email3, this.address, this.address2);
    }

    public DataContact withMobile(String mobile) {
        return new DataContact(id, this.firstname, this.middlename, this.lastname, this.photo, this.home, mobile, this.work, this.secondary, this.email, this.email2, this.email3, this.address, this.address2);
    }

    public DataContact withWork(String work) {
        return new DataContact(id, this.firstname, this.middlename, this.lastname, this.photo, this.home, this.mobile, work, this.secondary, this.email, this.email2, this.email3, this.address, this.address2);
    }

    public DataContact withSecondary(String secondary) {
        return new DataContact(id, this.firstname, this.middlename, this.lastname, this.photo, this.home, this.mobile, this.work, secondary, this.email, this.email2, this.email3, this.address, this.address2);
    }

    public DataContact withEmail(String email) {
        return new DataContact(id, this.firstname, this.middlename, this.lastname, this.photo, this.home, this.mobile, this.work, secondary, email, this.email2, this.email3, this.address, this.address2);
    }

    public DataContact withEmail2(String email2) {
        return new DataContact(id, this.firstname, this.middlename, this.lastname, this.photo, this.home, this.mobile, this.work, secondary, this.email, email2, this.email3, this.address, this.address2);
    }

    public DataContact withEmail3(String email3) {
        return new DataContact(id, this.firstname, this.middlename, this.lastname, this.photo, this.home, this.mobile, this.work, secondary, this.email, this.email2, email3, this.address, this.address2);
    }

    public DataContact withAddress(String address) {
        return new DataContact(id, this.firstname, this.middlename, this.lastname, this.photo, this.home, this.mobile, this.work, secondary, this.email, this.email2, this.email3, address, this.address2);
    }

    public DataContact withAddress2(String address2) {
        return new DataContact(id, this.firstname, this.middlename, this.lastname, this.photo, this.home, this.mobile, this.work, secondary, this.email, this.email2, this.email3, this.address, address2);
    }


}