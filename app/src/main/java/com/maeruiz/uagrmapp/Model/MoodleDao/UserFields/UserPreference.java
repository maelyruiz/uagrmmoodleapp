/*
 *  Copyright (C) 2012 Bill Antonia
 *
 *  This program is free software; you can redistribute it and/or
 *  modify it under the terms of the GNU General Public License
 *  as published by the Free Software Foundation; either version 2
 *  of the License, or (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program; if not, write to the Free Software
 *  Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */

package com.maeruiz.uagrmapp.Model.MoodleDao.UserFields;

import java.io.Serializable;

public class UserPreference implements Serializable {
  private String name=null;
  private String type=null;
  private String value=null;
  
  public UserPreference() {}
  
  public UserPreference(String type, String value) {
    this.type=type;
    this.value=value;
  }
  
  public void setType(String type) {
    this.type=type;
  }
  
  public void setValue(String value) {
    this.value=value;
  }
  
  public String getType() {
    return type;
  }
  
  public String getValue() {
    return value;
  }
  
  public void setUserPreference(String type, String value) {
    this.type=type;
    this.value=value;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
