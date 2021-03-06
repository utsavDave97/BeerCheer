package com.example.utsav.beercheer;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceFragmentCompat;


public class PreferenceFragment extends PreferenceFragmentCompat
{
    //create the fragment manager
    FragmentManager fm;
    //create the fragmentTransaction
    FragmentTransaction transaction;

    String[] address = {"beercheer@gmail.com"};

    @Override
    public void onCreatePreferences(Bundle bundle, String s)
    {
        //grab the manager
        fm = getFragmentManager();

        //grab the preference
        addPreferencesFromResource(R.xml.preferences);

        //create new preferences
        Preference feedbackPreference = findPreference("feedback");
        Preference callPreference = findPreference("call");
        Preference licensePreference = findPreference("license");
        Preference creditsPreference = findPreference("credits");
        Preference learnOurStory = findPreference("aboutUs");
        Preference locationPreference = findPreference("location");

        /**
         * Create the on preference click listeners below
         */
        learnOurStory.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                transaction = fm.beginTransaction();
                transaction.replace(R.id.settingsFragment, new learnOurStory());
                transaction.addToBackStack(null);
                transaction.commit();
                return false;
            }
        });

        locationPreference.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                Uri location = Uri.parse("geo:0,0?q=42.248204,-83.019325(St clair college");
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(location);

                if(intent.resolveActivity(getActivity().getPackageManager()) != null)
                {
                    startActivity(intent);
                    return  true;
                }
                else
                {
                    return false;
                }
            }
        });

        feedbackPreference.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:"));
                intent.putExtra(Intent.EXTRA_EMAIL,address);

                if(intent.resolveActivity(getActivity().getPackageManager()) != null)
                {
                    startActivity(intent);
                    return  true;
                }
                else
                {
                    return false;
                }

            }
        });

        callPreference.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("tel:+15196779787"));
                intent.putExtra(Intent.EXTRA_EMAIL,address);

                if(intent.resolveActivity(getActivity().getPackageManager()) != null)
                {
                    startActivity(intent);
                    return  true;
                }
                else
                {
                    return false;
                }

            }
        });

        licensePreference.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {

                Intent i = new Intent(getContext(), LicenseActivity.class);
                startActivity(i);

                return true;
            }
        });

        creditsPreference.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                Intent i = new Intent(getContext(), CreditsActivity.class);
                startActivity(i);

                return true;
            }
        });

    }

}
