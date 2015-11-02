// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package webhook.sample.web;

import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;
import webhook.sample.domain.Notifications;
import webhook.sample.web.NotificationsController;

privileged aspect NotificationsController_Roo_Controller {
    
    @RequestMapping(method = RequestMethod.POST, produces = "text/html")
    public String NotificationsController.create(@Valid Notifications notifications, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, notifications);
            return "notifications/create";
        }
        uiModel.asMap().clear();
        notifications.persist();
        return "redirect:/notifications/" + encodeUrlPathSegment(notifications.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(params = "form", produces = "text/html")
    public String NotificationsController.createForm(Model uiModel) {
        populateEditForm(uiModel, new Notifications());
        return "notifications/create";
    }
    
    @RequestMapping(value = "/{id}", produces = "text/html")
    public String NotificationsController.show(@PathVariable("id") Long id, Model uiModel) {
        uiModel.addAttribute("notifications", Notifications.findNotifications(id));
        uiModel.addAttribute("itemId", id);
        return "notifications/show";
    }
    
    @RequestMapping(produces = "text/html")
    public String NotificationsController.list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("notificationses", Notifications.findNotificationsEntries(firstResult, sizeNo, sortFieldName, sortOrder));
            float nrOfPages = (float) Notifications.countNotificationses() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("notificationses", Notifications.findAllNotificationses(sortFieldName, sortOrder));
        }
        return "notifications/list";
    }
    
    @RequestMapping(method = RequestMethod.PUT, produces = "text/html")
    public String NotificationsController.update(@Valid Notifications notifications, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, notifications);
            return "notifications/update";
        }
        uiModel.asMap().clear();
        notifications.merge();
        return "redirect:/notifications/" + encodeUrlPathSegment(notifications.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(value = "/{id}", params = "form", produces = "text/html")
    public String NotificationsController.updateForm(@PathVariable("id") Long id, Model uiModel) {
        populateEditForm(uiModel, Notifications.findNotifications(id));
        return "notifications/update";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
    public String NotificationsController.delete(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        Notifications notifications = Notifications.findNotifications(id);
        notifications.remove();
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/notifications";
    }
    
    void NotificationsController.populateEditForm(Model uiModel, Notifications notifications) {
        uiModel.addAttribute("notifications", notifications);
    }
    
    String NotificationsController.encodeUrlPathSegment(String pathSegment, HttpServletRequest httpServletRequest) {
        String enc = httpServletRequest.getCharacterEncoding();
        if (enc == null) {
            enc = WebUtils.DEFAULT_CHARACTER_ENCODING;
        }
        try {
            pathSegment = UriUtils.encodePathSegment(pathSegment, enc);
        } catch (UnsupportedEncodingException uee) {}
        return pathSegment;
    }
    
}
