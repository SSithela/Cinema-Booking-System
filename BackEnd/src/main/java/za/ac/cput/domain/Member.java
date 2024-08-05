package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Member {
    @Id
    private int member_id;
    private String passowrd;
    @OneToOne
    private User user;
    protected Member(){}
    private Member(Builder builder){}

    public int getMember_id() {
        return member_id;
    }

    public String getPassowrd() {
        return passowrd;
    }

    public User getUser() {
        return user;
    }

    public static class Builder{
        private int member_id;
        private String passowrd;
        private User user;

        public Builder setMember_id(int member_id) {
            this.member_id = member_id;
            return this;
        }

        public Builder setPassowrd(String passowrd) {
            this.passowrd = passowrd;
            return this;
        }

        public Builder setUser(User user) {
            this.user = user;
            return this;
        }

        public Builder copy(Member member){
            this.member_id=member.member_id;
            this.passowrd=member.passowrd;
            this.user=member.user;
            return this;
        }
        public Member build(){
            return new Member(this);
        }
    }
}
