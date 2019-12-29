package com.itn.terranode.presentation.view.main.office_screen;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.itn.terranode.R;
import com.itn.terranode.data.network.dtos.InformationAboutUser;
import com.itn.terranode.presentation.presenter.main.office_screen.OfficePresenter;
import com.itn.terranode.presentation.view.main.MainActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import moxy.MvpAppCompatFragment;
import moxy.presenter.InjectPresenter;

public class OfficeFragment extends MvpAppCompatFragment implements OfficeView {

    @BindView(R.id.screenNameTextView)
    TextView screenNameTextView;
    @BindView(R.id.userNameTextView)
    TextView userNameTextView;
    @BindView(R.id.personalIdTextView)
    TextView personalIdTextView;
    @BindView(R.id.currentLevelNameTextView)
    TextView currentLevelNameTextView;
    @BindView(R.id.photoImageView)
    ImageView photoImageView;
    @BindView(R.id.cashValueTextView)
    TextView cashValueTextView;
    @BindView(R.id.nodValueTextView)
    TextView nodValueTextView;
    @BindView(R.id.partnerValueTextView)
    TextView partnerValueTextView;
    @BindView(R.id.transferValueTextView)
    TextView transferValueTextView;
    @BindView(R.id.sponsorIdTextView)
    TextView sponsorIdTextView;
    private Unbinder unbinder;

    @InjectPresenter
    OfficePresenter presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_office, container, false);
        unbinder = ButterKnife.bind(this, view);
        screenNameTextView.setText("Personal Office");
        presenter.getInformationAboutUser();
        return view;
    }

    @Override
    public void showInformation(InformationAboutUser informationAboutUser) {
        userNameTextView.setText(informationAboutUser.getName());
        personalIdTextView.setText("Your personal ID:" + informationAboutUser.getId());
        currentLevelNameTextView.setText(informationAboutUser.getLevelInfo());
    }

    @OnClick(R.id.logout)
    public void onLogoutClicked() {
        quit();
    }

    private void quit() {
        presenter.clearAll();
        ((MainActivity) getActivity()).showLoginScreen();
    }

    @OnClick(R.id.imageButton)
    public void onImageButtonClicked() {
        Toast.makeText(getContext(),"откроем диалог со спонсором", Toast.LENGTH_SHORT).show();
    }
}
