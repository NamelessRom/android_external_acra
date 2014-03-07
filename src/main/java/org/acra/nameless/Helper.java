package org.acra.nameless;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Helper {

    public static boolean isNameless() {
        return existsInBuildProp("ro.nameless.version");
    }

    public static boolean existsInBuildProp(String filter) {
        final File f = new File("/system/build.prop");
        BufferedReader bufferedReader = null;
        if (f.exists() && f.canRead()) {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
                String s;
                while ((s = bufferedReader.readLine()) != null) {
                    if (s.contains(filter)) return true;
                }
            } catch (Exception whoops) {
                return false;
            } finally {
                try {
                    if (bufferedReader != null) bufferedReader.close();
                } catch (Exception ignored) {
                    // mepmep
                }
            }
        }
        return false;
    }
}
