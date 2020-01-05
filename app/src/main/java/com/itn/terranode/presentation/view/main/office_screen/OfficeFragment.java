package com.itn.terranode.presentation.view.main.office_screen;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.itn.terranode.R;
import com.itn.terranode.data.network.dtos.InformationAboutUser;
import com.itn.terranode.presentation.presenter.main.office_screen.OfficePresenter;
import com.itn.terranode.presentation.view.main.MainActivity;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import de.hdodenhof.circleimageview.CircleImageView;
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
    CircleImageView photoImageView;
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
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.imageButton)
    ImageView imageButton;
    private Unbinder unbinder;

    @InjectPresenter
    OfficePresenter presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_office, container, false);
        unbinder = ButterKnife.bind(this, view);
        screenNameTextView.setText(getResources().getString(R.string.p_office));
        presenter.getInformationAboutUser();
        return view;
    }

    @Override
    public void showInformation(InformationAboutUser informationAboutUser) {
        userNameTextView.setText(informationAboutUser.getName());
        personalIdTextView.setText(getResources().getString(R.string.string_with_string_to_textview, "Your personal ID:", informationAboutUser.getId()));
        currentLevelNameTextView.setText(informationAboutUser.getLevelInfo().getCurrentLevel().getName());
        if(informationAboutUser.getPhoto() == null){
            photoImageView.setVisibility(View.GONE);
        } else {
            Picasso.get()
                    .load(informationAboutUser.getPhoto())
                    .into(photoImageView);
        }
        cashValueTextView.setText(getResources().getString(R.string.dollar_with_string_to_textview, informationAboutUser.getBalance().getCash()));
        nodValueTextView.setText(getResources().getString(R.string.dollar_with_string_to_textview,informationAboutUser.getBalance().getNod()));
        partnerValueTextView.setText(getResources().getString(R.string.dollar_with_string_to_textview,informationAboutUser.getBalance().getPartner()));
        transferValueTextView.setText(getResources().getString(R.string.dollar_with_string_to_textview,informationAboutUser.getBalance().getTransfer()));
        sponsorIdTextView.setText(getResources().getString(R.string.string_with_string_to_textview,"Sponsor ID:", informationAboutUser.getSponsorId()));
        imageButton.setOnClickListener(v -> ((MainActivity) getActivity()).showChatActivityByUserId(informationAboutUser.getSponsorId(), "Sponsor"));
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.logout)
    void onLogoutClicked() {
        presenter.logout();
    }

    @Override
    public void quit() {
        presenter.clearAll();
        ((MainActivity) getActivity()).showLoginScreen();
    }

    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onDestroy() {
        presenter.destroy();
        super.onDestroy();
    }
}
