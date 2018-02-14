package org.sonar.server.platform.db.migration.version.v71;

import java.sql.SQLException;
import org.sonar.db.Database;
import org.sonar.server.platform.db.migration.sql.AlterColumnsBuilder;
import org.sonar.server.platform.db.migration.step.DdlChange;

import static org.sonar.server.platform.db.migration.def.IntegerColumnDef.newIntegerColumnDefBuilder;

public class MakeFileSourceLineCountNotNullable extends DdlChange {
  public MakeFileSourceLineCountNotNullable(Database db) {
    super(db);
  }

  @Override
  public void execute(Context context) throws SQLException {
    context.execute(new AlterColumnsBuilder(getDialect(), "file_sources")
      .updateColumn(newIntegerColumnDefBuilder()
        .setColumnName("line_count")
        .setIsNullable(false)
        .build())
      .build());
  }
}
