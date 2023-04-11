//
//  model.swift
//  iosApp
//
//  Created by Sven Beilfuß on 11.04.23.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation

struct Task: Codable{
    var task_id: String
    var title: String
    var is_done: Bool = false
    var start: String? = nil
    var end: String? = nil
    var content: String? = nil
    var group_id: String? = nil
}
