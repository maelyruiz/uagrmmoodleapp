package com.maeruiz.uagrmapp.Adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.maeruiz.uagrmapp.Model.MoodleDao.GroupsDao;
import com.maeruiz.uagrmapp.R;

import java.util.LinkedList;

/**
 * Created by maelyruiz on 5/29/17.
 */

public class CoursesExpandableAdapter extends BaseExpandableListAdapter {

    private LinkedList<GroupsDao> groups;
    private Context context;

    public CoursesExpandableAdapter(LinkedList<GroupsDao> grupos, Context context){

        this.groups = grupos;
        this.context = context;
    }
    @Override
    public int getGroupCount() {
        return groups.size();
    }

    @Override
    public int getChildrenCount(int i) {
        if ((groups !=null)&&i< groups.size())
            return groups.get(i).getActivities().size();

        return 0;
    }

    @Override
    public Object getGroup(int i) {
        if (groups !=null && i< groups.size())

            return groups.get(i);

        return null;
    }

    @Override
    public Object getChild(int i, int i1) {
        if (groups !=null && i< groups.size()) {

            if (groups.get(i).getActivities()!=null && i1< groups.get(i).getActivities().size())

                return groups.get(i).getActivities().get(i1);
        }


        return null;
    }

    @Override
    public long getGroupId(int i) {

        if (groups !=null && i< groups.size())

            return groups.get(i).getId();

        return 0;
    }

    @Override
    public long getChildId(int i, int i1) {
        if (groups !=null && i< groups.size()) {

            if (groups.get(i).getActivities()!=null && i1< groups.get(i).getActivities().size())

                return groups.get(i).getActivities().get(i1).getId();
        }

        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        if(groups!=null && i<groups.size()) {
            String headerTitle = (String) getGroup(i);
            if (view == null) {
                LayoutInflater infalInflater = (LayoutInflater) this.context
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = infalInflater.inflate(R.layout.expandablegroup_courses, null);
            }

            TextView lblListHeader = (TextView) view
                    .findViewById(R.id.tvGroupCourses);
            lblListHeader.setTypeface(null, Typeface.BOLD);
            lblListHeader.setText(headerTitle);

            return view;
        }
        return null;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {

        if((groups!=null && i<groups.size()) && (groups.get(i).getActivities()!=null && i1<groups.get(i).getActivities().size())) {
            final String childText = groups.get(i).getActivities().get(i1).getName();

            if (view == null) {
                LayoutInflater infalInflater = (LayoutInflater) this.context
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = infalInflater.inflate(R.layout.expandableitem_courses, null);
            }

            TextView txtListChild = (TextView) view
                    .findViewById(R.id.tvItemCourses);

            txtListChild.setText(childText);
            return view;

        }
        return null;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }



}
