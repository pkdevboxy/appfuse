/**
 * 
 */
package org.appfuse.webapp.client.ui.reloadOptions;

import org.appfuse.webapp.client.application.Application;
import org.appfuse.webapp.client.application.base.activity.AbstractBaseActivity;
import org.appfuse.webapp.client.ui.mainMenu.MainMenuPlace;
import org.appfuse.webapp.proxies.LookupConstantsProxy;

import com.github.gwtbootstrap.client.ui.constants.AlertType;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.web.bindery.requestfactory.shared.Receiver;
import com.google.web.bindery.requestfactory.shared.ServerFailure;

/**
 * @author ivangsa
 *
 */
public class ReloadOptionsActivity extends AbstractBaseActivity {


	public ReloadOptionsActivity(Application application) {
		super(application);
	}

	/* (non-Javadoc)
	 * @see com.google.gwt.activity.shared.Activity#start(com.google.gwt.user.client.ui.AcceptsOneWidget, com.google.gwt.event.shared.EventBus)
	 */
	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		requests.lookupRequest().reloadOptions().fire(new Receiver<LookupConstantsProxy>() {

			@Override
			public void onSuccess(LookupConstantsProxy response) {
				application.setLookupConstants(response);
				placeController.goTo(new MainMenuPlace());
				shell.addMessage(i18n.reload_succeeded(), AlertType.SUCCESS);
			}
			@Override
			public void onFailure(ServerFailure error) {
				super.onFailure(error);
			}
		});
	}

}
