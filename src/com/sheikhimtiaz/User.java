package com.sheikhimtiaz;

import java.util.Date;

public class User{
    String name;
    Date birth;

    private void stuff(){}

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof User))
            return false;
        User other = (User)o;
        boolean nameEquals = (this.name == null && other.name == null)
                || (this.name != null && this.name.equals(other.name));
        return this.birth == other.birth && nameEquals;
    }

}
