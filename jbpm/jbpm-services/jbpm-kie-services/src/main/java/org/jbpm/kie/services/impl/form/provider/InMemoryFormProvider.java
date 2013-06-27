package org.jbpm.kie.services.impl.form.provider;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;

import org.jbpm.kie.services.impl.model.ProcessDesc;
import org.kie.api.task.model.Task;

@ApplicationScoped
public class InMemoryFormProvider extends FreemakerFormProvider {

    private static final String DEFAULT_PROCESS = "DefaultProcess";
    private static final String DEFAULT_TASK = "DefaultTask";

    @Override
    public String render(String name, ProcessDesc process, Map<String, Object> renderContext) {
        InputStream template = null;
        if (process.getForms().containsKey(process.getId())) {
            template = new ByteArrayInputStream(process.getForms().get(process.getId()).getBytes());
        } else if (process.getForms().containsKey(process.getId() + "-taskform")) {
            template = new ByteArrayInputStream(process.getForms().get(process.getId() + "-taskform").getBytes());
        } else if (process.getForms().containsKey(DEFAULT_PROCESS)) {
            template = new ByteArrayInputStream(process.getForms().get(DEFAULT_PROCESS).getBytes());
        }

        if (template == null) return null;

        return render(name, template, renderContext);
    }

    @Override
    public String render(String name, Task task, ProcessDesc process, Map<String, Object> renderContext) {
        InputStream template = null;
        if(task != null && process != null){
            String taskName = task.getNames().get(0).getText();
            if (process.getForms().containsKey(taskName)) {
                template = new ByteArrayInputStream(process.getForms().get(taskName).getBytes());
            } else if (process.getForms().containsKey(taskName.replace(" ", "")+ "-taskform")) {
                template = new ByteArrayInputStream(process.getForms().get(taskName.replace(" ", "") + "-taskform").getBytes());
            } else if (process.getForms().containsKey(DEFAULT_TASK)) {
                template = new ByteArrayInputStream(process.getForms().get(DEFAULT_TASK).getBytes());
            }
        }

        if (template == null) return null;

        return render(name, template, renderContext);
    }

    @Override
    public int getPriority() {
        return 2;
    }

}