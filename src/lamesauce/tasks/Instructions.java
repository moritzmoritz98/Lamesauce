/*
 * Copyright (C) 2017 captnmo
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package lamesauce.tasks;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 *
 * @author captnmo
 */
public enum Instructions {
    AUTH("!auth"),
    ALIVE("!areyoualive"),
    ADD("!add"),
    ADMIN("!whoisadmin"),
    HELP("!help"),
    BEER("!bringbeer"),
    DEAUTH("!deauth");

    private String identifier;
    
    Instructions(String identifier) {
        this.identifier = identifier;
    }


    public String getIdentifier() {
        return identifier;
    }
    
    public static List<String> getIdentifiers() {
        return Arrays.stream(Instructions.values())
                .map(Instructions::getIdentifier)
                .collect( Collectors.toList());
    }

    public static Optional<Instructions> containsIdent(String identifier) {
        return Arrays.stream(Instructions.values())
                .filter(i -> i.getIdentifier().equals(identifier))
                .findFirst();
    }

    public static List<Instructions> changesUserData() {
        return Arrays.asList(ADD, AUTH, DEAUTH);
    }
    
}
