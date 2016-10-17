package net.ldauvilaire.sample.liquibase;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Rule;
import org.junit.Test;
import org.springframework.boot.test.rule.OutputCapture;

public class ApplicationTest {

	@Rule
	public OutputCapture outputCapture = new OutputCapture();

	@Test
	public void liquibaseApplicationTest() throws Exception {

		try {
			Application.main(new String[] { });
		} catch (IllegalStateException ex) {
		}

		String output = this.outputCapture.toString();
		assertThat(output).contains("Successfully acquired change log lock")
				.contains("Creating database history "
						+ "table with name: PUBLIC.DATABASECHANGELOG")
				.contains("Table person created")
				.contains("ChangeSet classpath:/db/"
						+ "changelog/db.changelog-master.yaml::1::"
						+ "ldauvilaire ran successfully")
				.contains("New row inserted into person")
				.contains("ChangeSet classpath:/db/changelog/"
						+ "db.changelog-master.yaml::2::"
						+ "ldauvilaire ran successfully")
				.contains("Successfully released change log lock");
	}
}
